package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateTestFiles {
    public static void main(String[] args) throws IOException {
        generateFile("src/test/resources/numbers_100.txt", 100);
        generateFile("src/test/resources/numbers_1000.txt", 1000);
        generateFile("src/test/resources/numbers_10000.txt", 10000);
        generateFile("src/test/resources/numbers_100000.txt", 100000);
        generateFile("src/test/resources/numbers_1000000.txt", 1000000);
    }

    private static void generateFile(String filePath, int count) throws IOException {
        Random random = new Random();
        String content = IntStream.range(0, count)
                .mapToObj(i -> String.valueOf(random.nextInt(1000)))
                .collect(Collectors.joining(" "));
        Files.write(Paths.get(filePath), content.getBytes());
    }
}