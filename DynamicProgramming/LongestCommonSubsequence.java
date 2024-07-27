package DynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "aabbaca";
        String s2 = "abcab";
        System.out.println("Iterative solution: " + longestCommonSubsequenceIterativeLength(s1, s2));
        System.out.println("Printing solution: " + printLongestCommonSubsequenceIterative(s1, s2));

        s1 = "ABCBDAB";
        s2 = "BDCAB";
        System.out.println("Iterative solution: " + longestCommonSubsequenceIterativeLength(s1, s2));
        System.out.println("Printing solution: " + printLongestCommonSubsequenceIterative(s1, s2));
        //should print BCAB
    }

    private static int longestCommonSubsequenceIterativeLength(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] lcs = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                }
            }
        }
        return lcs[n][m];
    }

    private static String printLongestCommonSubsequenceIterative(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        String[][] lcs = new String[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            lcs[i][0] = "";
        }
        for (int j = 0; j < m + 1; j++) {
            lcs[0][j] = "";
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    if (lcs[i][j - 1].length() > lcs[i - 1][j].length()) {
                        lcs[i][j] = lcs[i][j - 1];
                    } else {
                        lcs[i][j] = lcs[i - 1][j];
                    }
                }
            }
        }
        return lcs[n][m];
    }


}
