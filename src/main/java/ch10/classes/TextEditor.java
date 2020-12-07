package ch10.classes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TextEditor {

    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        te.performTasks();
    }

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
        Map<String, Set<String>> stats = new HashMap<>();
        for (String fileName : extractor.getInputFileNames()) {
            PatternFinder patternFinder = new PatternFinder(fileName, extractor.getPatterns());
            Set<String> foundPatterns = patternFinder.findPatternsInFile();
            stats.put(fileName, foundPatterns);
        }
        try ( BufferedWriter outputFile = Files.newBufferedWriter(Paths.get(extractor.getOutputFileName()), StandardOpenOption.CREATE) ) {
            outputFile.write(invertGroupByMap(stats).toString());
        }
    }

    private static <K, V> Map<V, Set<K>> invertGroupByMap(final Map<K, Set<V>> src)
    {
        return src.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(value -> new AbstractMap.SimpleImmutableEntry<>(value, entry.getKey())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));
    }
}
