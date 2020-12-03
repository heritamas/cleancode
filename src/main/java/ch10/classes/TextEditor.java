package ch10.classes;

import org.tomlj.Toml;
import org.tomlj.TomlArray;
import org.tomlj.TomlParseResult;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class TextEditor {

    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        te.performTasks();
    }

    Path config;
    TomlParseResult result;
    List<String> inputFiles = new ArrayList<>();
    String output;
    List<Pattern> patterns = new ArrayList<>();
    Map<String, Set<String>> stats = new HashMap<>();

    public void performTasks() {
        try {
            readConfig("tasks.toml");
            extract();
            doStats();
            writeStats();
            System.out.println("done");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readConfig (String configFile) throws URISyntaxException, IOException {
        config = Paths.get(getClass().getClassLoader().getResource(configFile).toURI());
        result = Toml.parse(config);
        if (result.hasErrors()) {
            result.errors().forEach(error -> System.err.println(error.toString()));
            throw new IllegalArgumentException("Config file had errors");
        }
    }

    private void extract() {
        TomlArray input = result.getArray("io.input");
        for (int i = 0 ; i < input.size(); ++i) {
            inputFiles.add(input.getString(i));
        }

        output = result.getString("io.output");

        TomlArray strings = result.getArray("task.patterns");
        for (int i = 0 ; i < strings.size(); ++i) {
            patterns.add(Pattern.compile(strings.getString(i), Pattern.CASE_INSENSITIVE));
        }

    }

    private void doStats() throws URISyntaxException, IOException {
        for (String fileName : inputFiles) {
            Path filePath = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
            for (String line : Files.readAllLines(filePath)) {
                for (Pattern pattern : patterns) {
                    if (pattern.matcher(line).find()) {
                        stats.merge(
                                pattern.toString(),
                                new HashSet<String>(Collections.singleton(fileName)),
                                (set, singleton) -> { set.addAll(singleton); return set;});
                    }
                }
            }
        }
    }

    private void writeStats() throws IOException {
        try ( BufferedWriter outputFile = Files.newBufferedWriter(Paths.get(output), StandardOpenOption.CREATE) ) {
            outputFile.write(stats.toString());
        }
    }

}
