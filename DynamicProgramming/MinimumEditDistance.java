package DynamicProgramming;

public class MinimumEditDistance {

    public static void main(String[] args) {
        System.out.println(minimumEditDistance("saturday", "sunday") == 3);
        System.out.println(minimumEditDistance("geek", "geeks") == 1);
    }

    private static int minimumEditDistance(String from, String to) {
        int l1 = from.length();
        int l2 = to.length();
        int[][] edit = new int[l1 + 1][l2 + 1];
        int defaultDist = 0;
        for (int i = 0; i < l1 + 1; i++) {
            edit[i][0] = defaultDist++;
        }
        defaultDist = 0;
        for (int j = 0; j < l2 + 1; j++) {
            edit[0][j] = defaultDist++;
        }
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (from.charAt(i - 1) == to.charAt(j - 1)) {
                    edit[i][j] = edit[i - 1][j - 1];
                } else {
                    edit[i][j] = 1 + Math.min(Math.min(edit[i][j - 1], edit[i - 1][j]), edit[i - 1][j - 1]);
                }
            }
        }
        return edit[l1][l2];
    }

}
