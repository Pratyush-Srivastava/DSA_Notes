package Bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetOfString {
    public static void main(String[] args) {
        System.out.println(subsetsOfString("abc").equals(Arrays.asList("", "a", "b", "ab", "c", "ac", "bc", "abc")));
        System.out.println(subsetsOfString("xy").equals(Arrays.asList("", "x", "y", "xy")));
    }

    private static List<String> subsetsOfString(String input) {
        List<String> subsetsOfString = new ArrayList<>();
        for (int iter = 0; iter < Math.pow(2, input.length()); iter++) {
            StringBuilder substring = new StringBuilder();
            for (int character = 0; character < input.length(); character++) {
                if (((int) Math.pow(2, character) & iter) != 0) {
                    substring.append(input.charAt(character));
                }
            }
            subsetsOfString.add(substring.toString());
        }
        return subsetsOfString;
    }
}
//iter 0 = 000 character = 001,010,100 ""
//iter 1 = 001 character = 001,010,100 "a"
//iter 2 = 010 character = 001,010,100 "b"
//iter 3 = 011 character = 001,010,100 "bc"
//iter 4 = 100 character = 001,010,100 "a"
//iter 5 = 101 character = 001,010,100 "ac"
//iter 6 = 110 character = 001,010,100 "ab"
//iter 7 = 111 character = 001,010,100 "abc"

//iter 0 = 00 character = 01,10 ""
//iter 1 = 01 character = 01,10 "x"
//iter 2 = 10 character = 01,10 "y"
//iter 3 = 11 character = 01,10 "xy"