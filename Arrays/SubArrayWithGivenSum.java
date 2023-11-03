package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(doesSubArrayExistsWithGivenSum(Arrays.asList(1, 4, 20, 3, 10, 5), 33));
        System.out.println(doesSubArrayExistsWithGivenSum(Arrays.asList(1, 4, 0, 0, 3, 10, 5), 7));
        System.out.println(doesSubArrayExistsWithGivenSum(Arrays.asList(2, 4), 3));

    }

    private static boolean doesSubArrayExistsWithGivenSum(List<Integer> numbers, int givenSum) {
        int currentSum = 0;
        HashSet<Integer> cumulativeSum = new HashSet<>();
        cumulativeSum.add(currentSum);
        for (Integer number : numbers) {
            currentSum += number;
            if (cumulativeSum.contains(currentSum - givenSum)) {
                return true;
            }
            cumulativeSum.add(currentSum);
        }
        return false;
    }
}
