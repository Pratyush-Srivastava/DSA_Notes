package Arrays;

import java.util.Arrays;
import java.util.List;

public class MaxDifferenceInArray {
    public static void main(String[] args) {
        System.out.println(maxDifferenceInArray(Arrays.asList(2, 3, 10, 6, 4, 8, 1)));
        System.out.println(maxDifferenceInArray(Arrays.asList(7, 9, 5, 6, 3, 2)));
        System.out.println(maxDifferenceInArray(Arrays.asList(10, 20, 30)));
        System.out.println(maxDifferenceInArray(Arrays.asList(30, 10, 8, 2)));
    }

    private static int maxDifferenceInArray(List<Integer> input) {
        int diff = input.get(1) - input.get(0);
        int min = input.get(0);
        for (int j = 1; j < input.size(); j++) {
            diff = Math.max(diff, input.get(j) - min);
            min = Math.min(min, input.get(j));
        }
        return diff;
    }
}
