package ch10.classes;

import org.tomlj.Toml;
import org.tomlj.TomlArray;
import org.tomlj.TomlParseResult;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TomlConfigExtractor {

    Path config;
    TomlParseResult result;
    String configFileName;

    public TomlConfigExtractor(String configFileName) throws IOException, URISyntaxException {
        this.configFileName = configFileName;
        readConfig();
    }

    public void readConfig () throws URISyntaxException, IOException {
        config = Paths.get(getClass().getClassLoader().getResource(configFileName).toURI());
        result = Toml.parse(config);
        if (result.hasErrors()) {
            result.errors().forEach(error -> System.err.println(error.toString()));
            throw new IllegalArgumentException("Config file had errors");
        }
    }

    public List<Pattern> getPatterns() {
        List<Pattern> patterns = new ArrayList<>();
        TomlArray strings = result.getArray("task.patterns");
        for (int i = 0 ; i < strings.size(); ++i) {
            patterns.add(Pattern.compile(strings.getString(i), Pattern.CASE_INSENSITIVE));
        }
        return patterns;
    }

    public String getOutputFileName() {
        return result.getString("io.output");
    }

    public List<String> getInputFileNames() {
        List<String> inputFiles = new ArrayList<>();
        TomlArray input = result.getArray("io.input");
        for (int i = 0 ; i < input.size(); ++i) {
            inputFiles.add(input.getString(i));
        }
        return inputFiles;
    }
}
