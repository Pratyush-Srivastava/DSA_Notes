package Strings;

import java.util.Arrays;

/**
 * This is based on the logic that the longest prefix for (i-1) will be from
 * 0 to len-1 where len = lps[i-1} and if the char at len is equal to i then you can
 * have lps[i] = lps[i-1] + 1;
 */
public class LongestProperPrefixSuffixArray {
    public static void main(String[] args) {
        String input;
        input = "abacabad";
        System.out.println(Arrays.toString(input.toCharArray()));
        System.out.println(Arrays.toString(longestProperPrefixSuffix(input)));
        input = "abbabb";
        System.out.println(Arrays.toString(input.toCharArray()));
        System.out.println(Arrays.toString(longestProperPrefixSuffix(input)));
        input = "aaabaaaac";
        System.out.println(Arrays.toString(input.toCharArray()));
        System.out.println(Arrays.toString(longestProperPrefixSuffix(input)));
        input = "aaaa";
        System.out.println(Arrays.toString(input.toCharArray()));
        System.out.println(Arrays.toString(longestProperPrefixSuffix(input)));
        input = "abcbabca";
        System.out.println(Arrays.toString(input.toCharArray()));
        System.out.println(Arrays.toString(longestProperPrefixSuffix(input)));
        input = "ababc";
        System.out.println(Arrays.toString(input.toCharArray()));
        System.out.println(Arrays.toString(longestProperPrefixSuffix(input)));
        input = "abcd";
        System.out.println(Arrays.toString(input.toCharArray()));
        System.out.println(Arrays.toString(longestProperPrefixSuffix(input)));
        input = "ababab";
        System.out.println(Arrays.toString(input.toCharArray()));
        System.out.println(Arrays.toString(longestProperPrefixSuffix(input)));
    }

    private static int[] longestProperPrefixSuffix(String input) {
        int[] lps = new int[input.length()];
        int i = 1;
        int len = lps[i - 1]; // len represents lps of previous index
        while (i < input.length()) {
            if (input.charAt(i) == input.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len == 0) {
                lps[i] = 0;
                i++;
            } else {
                len = lps[len - 1];
            }
        }
        return lps;
    }
}
