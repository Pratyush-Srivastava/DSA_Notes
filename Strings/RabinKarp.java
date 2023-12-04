package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Rabin karp uses a hashing function. It matches the hashing function before comparing the pattern with
 * each window of text. The hashing function should be complex to avoid spurious hits. Make sure you can roll the
 * hashing function along the windows of text.
 * Note while calculating alphabet number you could be making a mistake if both capital and small letters
 * are involved.
 */
public class RabinKarp {
    private static final int PRIME = 7;

    public static void main(String[] args) {
        System.out.println(rabinKarpAlgorithm("AAAAA", "AAA"));
        System.out.println(rabinKarpAlgorithm("ABDABCBABC", "ABC"));
        System.out.println(rabinKarpAlgorithm("abcd", "xyz"));
    }

    private static List<Integer> rabinKarpAlgorithm(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int patternHash = hashFunction(pattern, 0, pattern.length() - 1);
        int currentTextHash = hashFunction(text, 0, pattern.length() - 1);
        for (int startText = 0; startText <= text.length() - pattern.length(); startText++) {
            if (currentTextHash == patternHash) {
                for (int startPattern = 0; startPattern < pattern.length(); startPattern++) {
                    if (text.charAt(startText + startPattern) != pattern.charAt(startPattern)) {
                        break;
                    }
                    if (startPattern == pattern.length() - 1) {
                        indices.add(startText);
                    }
                }
            } else if (startText < text.length() - pattern.length()) {
                currentTextHash = rollHashFunction(currentTextHash, text.charAt(startText),
                        text.charAt(startText + pattern.length()), pattern.length());
            }
        }
        return indices;
    }

    private static int hashFunction(String input, int start, int end) {
        int power = 0;
        int res = 0;
        for (int i = start; i <= end; i++) {
            int alphabetNo = alphabetNumber(input.charAt(i));
            res += alphabetNo * Math.pow(PRIME, power);
            power++;
        }
        return res;
    }

    private static int rollHashFunction(int currentHash, char prevChar, char newChar, int patternLength) {
        return (currentHash - alphabetNumber(prevChar)) / PRIME +
                ((int) Math.pow(PRIME, patternLength - 1) * alphabetNumber(newChar));
    }

    private static int alphabetNumber(char ch) {
        return ch - 'A' + 1;
    }
}
