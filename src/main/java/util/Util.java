package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {

    public List<String> readFile(String fileName) throws IOException {
        Path path = Paths.get(Util.class.getResource("/" + fileName).getPath());
        return Files.readAllLines(path);
    }

    public List<Integer> readCommaSeparatedFile(String fileName) throws IOException {
        return Arrays.stream(readFile(fileName).get(0).split(","))
                .mapToInt(s ->Integer.parseInt(s.trim()))
                .boxed()
                .collect(Collectors.toList());
    }

    public IntStream readIntStream(String fileName) throws IOException {
        return Arrays.stream(readFile(fileName).get(0).split(","))
                .mapToInt(s ->Integer.parseInt(s.trim()));
    }
}
