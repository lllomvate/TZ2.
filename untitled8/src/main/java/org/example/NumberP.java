package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class NumberP {

    public static void main(String[] args) {
        String filePath = "src/test/resources/numbers"; // Укажите правильный путь к файлу
        try {
            List<Integer> numbers = readNumbersFromFile(filePath);
            System.out.println("Минимальное: " + _min(numbers));
            System.out.println("Максимальное: " + _max(numbers));
            System.out.println("Сумма: " + _sum(numbers));
            System.out.println("Произведение: " + _mult(numbers));
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.stream(content.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int _min(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).orElseThrow(NoSuchElementException::new);
    }

    public static int _max(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow(NoSuchElementException::new);
    }

    public static int _sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static long _mult(List<Integer> numbers) {
        return numbers.stream().reduce(1, (a, b) -> a * b);
    }
}