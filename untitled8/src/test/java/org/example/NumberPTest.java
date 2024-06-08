package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberPTest {

    private static final String TEST_FILE = "src/test/resources/numbers_test";

    @Test
    public void testReadNumbersFromFile() throws IOException {
        List<Integer> numbers = NumberP.readNumbersFromFile(TEST_FILE);
        List<Integer> expectedNumbers = Arrays.asList(5, 8, 2, 9, 4, 1);

        assertEquals(expectedNumbers, numbers);
    }

    // Другие тестовые методы
    @Test
    public void testMin() throws IOException {
        List<Integer> numbers = NumberP.readNumbersFromFile(TEST_FILE);
        assertEquals(1, NumberP._min(numbers));
    }

    @Test
    public void testMax() throws IOException {
        List<Integer> numbers = NumberP.readNumbersFromFile(TEST_FILE);
        assertEquals(9, NumberP._max(numbers));
    }

    @Test
    public void testSum() throws IOException {
        List<Integer> numbers = NumberP.readNumbersFromFile(TEST_FILE);
        assertEquals(29, NumberP._sum(numbers));
    }

    @Test
    public void testMult() throws IOException {
        List<Integer> numbers = NumberP.readNumbersFromFile(TEST_FILE);
        assertEquals(2880, NumberP._mult(numbers));
    }
}