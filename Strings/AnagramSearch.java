package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Return true if any permutation of the pattern is present in the text
 */
public class AnagramSearch {
    private static final int PRIME = 2;

    public static void main(String[] args) {
        System.out.println(anagramSearch("geeksforgeeks", "frog"));
        System.out.println(anagramSearch("geeksforgeeks", "rseek"));
    }

    private static boolean anagramSearch(String text, String pattern) {
        if (pattern.length() >= text.length()) {
            return false;
        }
        long patternHash = hashFunction(pattern);
        HashMap<Character, Integer> patternChars = fillCharacters(pattern);

        String currentText = text.substring(0, pattern.length());
        long currentHash = hashFunction(currentText);
        HashMap<Character, Integer> currentChars = fillCharacters(currentText);
        int t = 0;
        while (t <= text.length() - pattern.length()) {
            if (currentHash == patternHash && currentChars.equals(patternChars)) {
                return true;
            } else if (t < text.length() - pattern.length()) {
                char oldChar = text.charAt(t);
                char newChar = text.charAt(t + pattern.length());
                currentHash = rollingHash(oldChar, newChar, currentHash);
                rollCharacters(oldChar, newChar, currentChars);
            }
            t++;
        }
        return false;
    }

    private static HashMap<Character, Integer> fillCharacters(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private static void rollCharacters(char oldChar, char newChar, HashMap<Character, Integer> map) {
        if (map.get(oldChar) == 1) {
            map.remove(oldChar);
        } else {
            map.put(oldChar, map.get(oldChar) - 1);
        }
        if (map.containsKey(newChar)) {
            map.put(newChar, map.get(newChar) + 1);
        } else {
            map.put(newChar, 1);
        }
    }

    private static long hashFunction(String input) {
        long res = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            res += Math.pow(alphabetNumber(ch), PRIME);
        }
        return res;
    }

    private static long rollingHash(char oldChar, char newChar, long currentHash) {
        currentHash = currentHash - (int) Math.pow(alphabetNumber(oldChar), PRIME);
        currentHash = currentHash + (int) Math.pow(alphabetNumber(newChar), PRIME);
        return currentHash;
    }

    //works only for small alphabets
    private static int alphabetNumber(char ch) {
        return ch - 'a' + 1;
    }
}
