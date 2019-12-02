package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Util {

    public static List<String> readFile(String fileName) throws IOException {
        Path path = Paths.get(Util.class.getResource("/" + fileName).getPath());
        return Files.readAllLines(path);
    }

    public static List<Integer> readCommaSeparatedFile(String fileName) throws IOException {
        Path path = Paths.get(Util.class.getResource("/" + fileName).getPath());
        return Arrays.stream(Files.readAllLines(path).get(0).split(","))
                .mapToInt(s ->Integer.parseInt(s.trim()))
                .boxed()
                .collect(Collectors.toList());
    }
}
