package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringDistinctChars {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithDistinctCharacters("abcdabc") == 4);
        System.out.println(longestSubstringWithDistinctCharacters("aaa") == 1);
        System.out.println(longestSubstringWithDistinctCharacters("abaacdbab") == 4);
        System.out.println(longestSubstringWithDistinctCharacters("aabbcdd") == 3);
        System.out.println(longestSubstringWithDistinctCharacters("abcadba") == 4);
    }

    private static int longestSubstringWithDistinctCharacters(String s) {
        int max = 0;
        int length = 0;
        Map<Character, Integer> previousIndex = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (previousIndex.containsKey(ch) && previousIndex.get(ch) >= i) {
                i = previousIndex.get(ch) + 1;
                length = j - i + 1;
            } else {
                length++;
            }
            previousIndex.put(ch, j);
            max = Math.max(length, max);
        }
        return max;

    }
}
