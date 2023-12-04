package Strings;

import java.util.ArrayList;
import java.util.List;

/**
* KMP algorithm helps for pattern searching in O(text) + O(pattern). Space - O(pattern)
 * It also works for cases when pattern have repetitions of characters.
*/

public class KMP {

    public static void main(String[] args) {
        System.out.println(kmpPatternMatching("ababcababaad", "ababa"));
        System.out.println(kmpPatternMatching("aaaaab", "aaaa"));
    }

    private static List<Integer> kmpPatternMatching(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int t = 0;
        int p = 0;
        int[] lpsOfPattern = lpsOfPattern(pattern);
        while (t < text.length() && p < pattern.length()) {
            if (text.charAt(t) == pattern.charAt(p)) {
                t++;
                p++;
            } else {
                if (p == 0) {
                    t++;
                } else {
                    p = lpsOfPattern[p - 1];
                }
            }
            if (p == pattern.length()) {
                indices.add(t - pattern.length());
                p = lpsOfPattern[p - 1];
            }
        }
        return indices;
    }

    private static int[] lpsOfPattern(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int i = 1;
        int len = lps[i - 1];
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
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
