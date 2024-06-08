package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.NoSuchElementException;

public class GenerateTestFileMini {

    public static void main(String[] args) throws IOException {
        generateFileWithAnswers("src/test/resources/test1.txt", "src/test/resources/test1_ans.txt", 100);
        generateFileWithAnswers("src/test/resources/test2.txt", "src/test/resources/test2_ans.txt", 1000);
        generateFileWithAnswers("src/test/resources/test3.txt", "src/test/resources/test3_ans.txt", 10000);
        generateFileWithAnswers("src/test/resources/test4.txt", "src/test/resources/test4_ans.txt", 100000);
        generateFileWithAnswers("src/test/resources/test5.txt", "src/test/resources/test5_ans.txt", 1000000);
    }

    private static void generateFileWithAnswers(String filePath, String answerFilePath, int count) throws IOException {
        Random random = new Random();
        List<Integer> numbers = IntStream.range(0, count)
                .mapToObj(i -> random.nextInt(1000))
                .collect(Collectors.toList());
        String content = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        Files.write(Paths.get(filePath), content.getBytes());

        int min = numbers.stream().min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        int max = numbers.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        long mult = numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);

        String answerContent = String.format("min:%d max:%d sum:%d mult:%d", min, max, sum, mult);
        Files.write(Paths.get(answerFilePath), answerContent.getBytes());
    }
}