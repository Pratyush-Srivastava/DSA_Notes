package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequenceWithoutOrder {
    public static void main(String[] args) {
        System.out.println(longestConsecutiveSubsequence(new int[]{1, 9, 3, 4, 2, 20}));
        System.out.println(longestConsecutiveSubsequence(new int[]{8, 20, 7, 30}));
        System.out.println(longestConsecutiveSubsequence(new int[]{20, 30, 40}));
        System.out.println(longestConsecutiveSubsequence(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }


    private static int longestConsecutiveSubsequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int number : arr) {
            set.add(number);
        }
        int maxConsecutiveLength = 0;
        for (int number : set) {
            int consecutiveLength = 1;
            if (!set.contains(number - 1)) {
                // starting of subsequence
                int next = number + 1;
                while (set.contains(next)) {
                    consecutiveLength++;
                    next++;
                }
            }
            maxConsecutiveLength = Math.max(consecutiveLength, maxConsecutiveLength);
        }
        return maxConsecutiveLength;
    }

}
