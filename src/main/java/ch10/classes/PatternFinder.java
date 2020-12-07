package ch10.classes;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class PatternFinder {
    
    String fileName;
    List<Pattern> patterns;
    Set<String> foundPatterns = new HashSet<String>();

    public PatternFinder(String fileName, List<Pattern> patterns) {
        this.fileName = fileName;
        this.patterns = patterns;
    }

    public Set<String> findPatternsInFile() throws URISyntaxException, IOException {
        Path filePath = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        for (String line : Files.readAllLines(filePath)) {
            for (Pattern pattern : patterns) {
                if (pattern.matcher(line).find()) {
                    foundPatterns.add(pattern.toString());
                }
            }
        }
        return foundPatterns;
    }
    
}
