package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {
    public static void main(String[] args) {
        System.out.println("Permutations are : " + permutationsOfString(0, "ABC") + " Number: " + permutationsOfString(0, "ABC").size());
        System.out.println("Permutations are : " + permutationsOfString(0, "ABCD") + " Number: " + permutationsOfString(0, "ABCD").size());
        System.out.println("Permutations are : " + permutationsOfString(0, "") + " Number: " + permutationsOfString(0, "").size());
        System.out.println("Permutations are : " + permutationsOfString(0, "ABCDE") + " Number: " + permutationsOfString(0, "ABCDE").size());
    }

    private static List<String> permutationsOfString(int iter, String input) {
        if (iter == input.length()) {
            return Collections.singletonList("");
        }
        List<String> permutations = new ArrayList<>();
        List<String> remainingStrings = permutationsOfString(iter + 1, input);
        for (String remainingString : remainingStrings) {
            for (int character = 0; character <= remainingString.length(); character++) {
                StringBuilder stringBuilder = new StringBuilder(remainingString);
                stringBuilder.insert(character, input.charAt(iter));
                permutations.add(stringBuilder.toString());
            }
        }
        return permutations;
    }
}
