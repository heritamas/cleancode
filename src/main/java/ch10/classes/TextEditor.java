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
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextEditor {

    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        te.performTasks();
    }
    
    Map<String, Set<String>> stats = new HashMap<>();

    public void performTasks() {
        try {
            TomlConfigExtractor extractor = new TomlConfigExtractor("tasks.toml");
            doStats(extractor);
            System.out.println("done");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doStats(TomlConfigExtractor extractor) throws URISyntaxException, IOException {
        for (String fileName : extractor.getInputFileNames()) {
            PatternFinder patternFinder = new PatternFinder(fileName, extractor.getPatterns());
            Set<String> foundPatterns = patternFinder.foundPatternsInFile();
            stats.put(fileName, foundPatterns);
        }
        try ( BufferedWriter outputFile = Files.newBufferedWriter(Paths.get(extractor.getOutputFileName()), StandardOpenOption.CREATE) ) {
            outputFile.write(stats.toString());
        }
    }

    public static <K, V> Map<V, Set<K>> invertGroupByMap(final Map<K, Set<V>> src)
    {
        return src.entrySet().stream()
                .flatMap(e -> e.getValue().stream().map(a -> new AbstractMap.SimpleImmutableEntry<>(a, e.getKey())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }

}
