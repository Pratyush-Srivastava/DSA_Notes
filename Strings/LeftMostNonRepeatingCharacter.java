package Strings;

import java.util.Arrays;

public class LeftMostNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(indexOfLeftMostNonRepeatingCharacter("geeksforgeeks"));
        System.out.println(indexOfLeftMostNonRepeatingCharacter("abcabc"));
        System.out.println(indexOfLeftMostNonRepeatingCharacter("apple"));
    }

    private static int indexOfLeftMostNonRepeatingCharacter(String s) {
        int[] frequency = new int[26];//valid for only small alphabets
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(frequency));
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
