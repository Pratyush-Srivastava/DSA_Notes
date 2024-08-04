package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetOfStringRecursive {
    public static void main(String[] args) {

        List<String> dynamicList = Arrays.asList("a", "b");
        String[] staticList = {"a", "b"};
        System.out.println("First approach");
        System.out.println(subsetOfString(0, ""));
        System.out.println(subsetOfString(0, "abc"));
        System.out.println(subsetOfString(0, "a"));
        System.out.println(subsetOfString(0, "abcd"));

        System.out.println("Second approach");
        System.out.println(subsequencesOfString(0, ""));
        System.out.println(subsequencesOfString(3, "abc"));
        System.out.println(subsequencesOfString(1, "a"));
        System.out.println(subsequencesOfString(4, "abcd"));
    }

    private static List<String> subsetOfString(int iter, String input) {
        List<String> subsetsOfString = new ArrayList<>();
        if (iter >= input.length()) {
            return Collections.singletonList("");
        }
        List<String> subsetsOfRemainingString = subsetOfString(iter + 1, input);
        for (String substring : subsetsOfRemainingString) {
            subsetsOfString.add(substring);
            subsetsOfString.add(input.charAt(iter) + substring);
        }
        return subsetsOfString;
    }

    private static List<String> subsequencesOfString(int n, String input) {
        List<String> subsequences = new ArrayList<>();
        if (n == 0) {
            subsequences.add("");
            return subsequences;
        }
        List<String> remainingSubsequences = subsequencesOfString(n - 1, input);
        for (int i = 0; i < remainingSubsequences.size(); i++) {
            String subsequence = remainingSubsequences.get(i);
            subsequences.add(subsequence);
            subsequences.add(subsequence + input.charAt(n - 1));
        }
        return subsequences;
    }

}
