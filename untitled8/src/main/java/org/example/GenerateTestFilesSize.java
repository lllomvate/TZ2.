package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateTestFilesSize {
    public static void main(String[] args) throws IOException {
        generateFile("src/test/resources/numbers_small.txt", 100);
        generateFile("src/test/resources/numbers_medium.txt", 1000);
        generateFile("src/test/resources/numbers_large.txt", 10000);
    }

    private static void generateFile(String filePath, int count) throws IOException {
        Random random = new Random();
        String content = IntStream.range(0, count)
                .mapToObj(i -> String.valueOf(random.nextInt(1000)))
                .collect(Collectors.joining(" "));
        Files.write(Paths.get(filePath), content.getBytes());
    }
}
