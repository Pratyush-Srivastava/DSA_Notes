package Strings;

import java.util.ArrayList;
import java.util.List;

public class NaivePatternMatching {
    public static void main(String[] args) {
        System.out.println(patternMatching("ABABABCD", "ABAB"));
        System.out.println(patternMatching("ABCABCD", "ABCD"));
        System.out.println(patternMatching("AAAAA", "AAA"));
    }

    private static List<Integer> patternMatching(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        for (int startingIndex = 0; startingIndex <= text.length() - pattern.length(); startingIndex++) {
            int patternIndex = 0;
            for (int textIndex = startingIndex; textIndex < startingIndex + pattern.length() ; textIndex++) {
                if (text.charAt(textIndex) != pattern.charAt(patternIndex)) {
                    break;
                }
                if (patternIndex == pattern.length() - 1) {
                    indices.add(startingIndex);
                    patternIndex = 0;
                }
                patternIndex++;
            }
        }
        return indices;
    }
}
