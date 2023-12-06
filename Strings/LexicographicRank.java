package Strings;


/**
 * After you sort the string alphabets in all permutations, return the rank of this string
 */
public class LexicographicRank {
    private static final int NUMBER_OF_ALPHABETS = 26;
    public static void main(String[] args) {
        System.out.println(lexicographicRank("ABCD") == 1);
        System.out.println(lexicographicRank("BAC") == 3);
        System.out.println(lexicographicRank("DCBA") == 24);
        System.out.println(lexicographicRank("STRING") == 598);
        System.out.println(lexicographicRank("MXB") == 4);
    }

    private static long lexicographicRank(String s) {
        int[] currentAlphaRank = currentAlphaRank(s);
        long rank = 0;
        int charsToProcess = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            int alpha = alphabetNumber(s.charAt(i));
            int currentCharRank = currentAlphaRank[alpha];
            rank += (currentCharRank - 1) * factorial(charsToProcess);
            charsToProcess--;
            updateCurrentAlphaRank(currentAlphaRank, alpha);
        }
        return rank + 1;
    }

    private static void updateCurrentAlphaRank(int[] currentAlphaRank, int alpha) {
        for (int j = alpha + 1; j < NUMBER_OF_ALPHABETS; j++) {
            if (currentAlphaRank[j] > 0) {
                currentAlphaRank[j]--;
            }
        }
    }

    private static int[] currentAlphaRank(String s) {
        int[] frequency = new int[NUMBER_OF_ALPHABETS];
        for (int i = 0; i < s.length(); i++) {
            int alpha = alphabetNumber(s.charAt(i));
            frequency[alpha]++;
        }
        int[] currentAlphabetRank = new int[NUMBER_OF_ALPHABETS];
        int alphaRank = 1;
        for (int i = 0; i < NUMBER_OF_ALPHABETS; i++) {
            if (frequency[i] > 0) {
                currentAlphabetRank[i] = alphaRank;
                alphaRank++;
            }
        }
        return currentAlphabetRank;
    }

    private static int alphabetNumber(char ch) {
        return ch - 'A';
    }

    private static long factorial(int n) {
        long prod = 1;
        while (n > 1) {
            prod = n * prod;
            n--;
        }
        return prod;
    }
}
