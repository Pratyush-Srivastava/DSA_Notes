package Mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivisorsOfNumber {
    public static void main(String[] args) {
        System.out.println(divisorsOfNumber(100).equals(Arrays.asList(1, 2, 4, 5, 10, 20, 25, 50, 100)));
        System.out.println(divisorsOfNumber(2).equals(Arrays.asList(1, 2)));
        System.out.println(divisorsOfNumber(25).equals(Arrays.asList(1, 5, 25)));
        System.out.println(divisorsOfNumber(1).equals(Collections.singletonList(1)));
        System.out.println(divisorsOfNumber(53).equals(Arrays.asList(1, 53)));

    }

    private static List<Integer> divisorsOfNumber(int number) {
        int iter = 1;
        List<Integer> firstDivisors = new ArrayList<>();
        List<Integer> lastDivisors = new ArrayList<>();
        while (iter <= Math.sqrt(number)) {
            if (number % iter == 0) {
                if (iter == number / iter) {
                    firstDivisors.add(iter);
                } else {
                    firstDivisors.add(iter);
                    lastDivisors.add(number / iter);
                }
            }
            iter++;
        }
        Collections.reverse(lastDivisors);
        firstDivisors.addAll(lastDivisors);
        return firstDivisors;

    }
}
