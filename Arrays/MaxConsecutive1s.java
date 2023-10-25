package Arrays;

import java.util.Arrays;
import java.util.List;

public class MaxConsecutive1s {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(Arrays.asList(0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0)));
        System.out.println(maxConsecutiveOnes(Arrays.asList(0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0)));
        System.out.println(maxConsecutiveOnes(Arrays.asList(0, 0, 0, 0)));
        System.out.println(maxConsecutiveOnes(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1)));
    }

    private static int maxConsecutiveOnes(List<Integer> binaryArray) {
        int maxConsecutiveOnes = 0;
        int i = 0;
        while (i < binaryArray.size()) {
            int consecutiveOnes = 0;
            while (i < binaryArray.size() && binaryArray.get(i) == 1) {
                consecutiveOnes++;
                i++;
            }
            if (consecutiveOnes > maxConsecutiveOnes) {
                maxConsecutiveOnes = consecutiveOnes;
            }
            i++;
        }
        return maxConsecutiveOnes;
    }
}
