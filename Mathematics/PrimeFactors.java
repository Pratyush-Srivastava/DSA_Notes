package Mathematics;

import java.util.*;

public class PrimeFactors {
    public static void main(String[] args) {
        System.out.println(primeFactors(36).equals(Arrays.asList(2, 2, 3, 3)));
        System.out.println(primeFactors(75).equals(Arrays.asList(3, 5, 5)));
        System.out.println(primeFactors(101).equals(Collections.singletonList(101)));
        System.out.println(primeFactors(88).equals(Arrays.asList(2, 2, 2, 11)));
        System.out.println(primeFactors(8).equals(Arrays.asList(2, 2, 2)));
    }

    private static List<Integer> primeFactors(int number) {
        int iter = 2;
        List<Integer> primeFactors = new ArrayList<>();
        while (iter <= Math.sqrt(number)) {
            while (number % iter == 0) {
                number = number / iter;
                primeFactors.add(iter);
            }
            iter++;
        }
        //this condition is added if the last item left is a prime factor
        if (number > 1) {
            primeFactors.add(number);
        }
        return primeFactors;
    }
}
