package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class NumbersOperations {

    public static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.stream(content.split(" "))
                .filter(str -> !str.trim().isEmpty()) // заменено на trim().isEmpty() для совместимости с Java 8
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int findMin(List<Integer> numbers) {
        return numbers.stream().min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
    }

    public static int getSum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static long getMult(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
    }
}