package Mathematics;

import java.util.*;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(findPrimeNumbersLessThanOrEqualToNumber(23).equals(Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23)));
        System.out.println(findPrimeNumbersLessThanOrEqualToNumber(54).equals(Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)));
        System.out.println(findPrimeNumbersLessThanOrEqualToNumber(102).equals(Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101)));
    }

    private static List<Integer> findPrimeNumbersLessThanOrEqualToNumber(int number) {
        List<Integer> primeNumbers = new ArrayList<>();
        Set<Integer> compositeNumbers = new HashSet<>();
        int iter = 2;
        while (iter <= Math.sqrt(number)) {
            if (!compositeNumbers.contains(iter)) {
                for (int a = 2; a * iter <= number; a++) {
                    compositeNumbers.add(a * iter);
                }
            }
            iter++;
        }
        for (int a = 2; a <= number; a++) {
            if (!compositeNumbers.contains(a)) {
                primeNumbers.add(a);
            }
        }
        return primeNumbers;
    }
}
