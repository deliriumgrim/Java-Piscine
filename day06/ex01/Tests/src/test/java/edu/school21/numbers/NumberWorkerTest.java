package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 89, 191, 2147483647})
    public void isPrimeForPrimes(int prime) {
        Assertions.assertTrue(new NumberWorker().isPrime(prime));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 9, 10, 18, 58, 100, 122, 500, 100250})
    public void isPrimeForNotPrimes(int notPrime) {
        Assertions.assertFalse(new NumberWorker().isPrime(notPrime));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -5, -7, -24599, -352523, -100, -4653, -325, -64})
    public void isPrimeForIncorrectNumbers(int incorrectNumbers) {
        Assertions.assertThrows(RuntimeException.class, () -> new NumberWorker().isPrime(incorrectNumbers));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    public void isSumCorrect(int input, int expected){
        Assertions.assertEquals(expected, new NumberWorker().digitsSum(input));
    }
}
