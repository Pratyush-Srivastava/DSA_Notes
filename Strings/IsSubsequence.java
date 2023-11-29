package Strings;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("ABCDE", "AED"));
        System.out.println(isSubsequence("ABCD", "BD"));
        System.out.println(isSubsequence("AAAABADA", "AABD"));
    }

    private static boolean isSubsequence(String str, String testString) {
        int i = 0;
        int j = 0;
        while (i < testString.length() && j < str.length()) {
            if (testString.charAt(i) == str.charAt(j)) {
                j++;
                i++;
            } else {
                j++;
            }
        }
        return (i == testString.length());
    }
}
