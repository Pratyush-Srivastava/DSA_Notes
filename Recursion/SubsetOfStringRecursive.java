package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetOfStringRecursive {
    public static void main(String[] args) {
        System.out.println(subsetOfString(0, ""));
        System.out.println(subsetOfString(0, "abc"));
        System.out.println(subsetOfString(0, "a"));
        System.out.println(subsetOfString(0, "abcd"));
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
}
