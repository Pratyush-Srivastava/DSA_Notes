package DynamicProgramming;

public class Knapsack01 {

    public static void main(String[] args) {
        int[] wt = {4, 5, 1};
        int[] val = {1, 2, 3};
        int W = 4;

        System.out.println(knapsack01Problem(W, wt, val) == 3);
    }

    private static int knapsack01Problem(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] value = new int[n + 1][W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (j - wt[i - 1] >= 0) {
                    value[i][j] = Math.max(val[i - 1] + value[i - 1][j - wt[i - 1]], value[i - 1][j]);
                } else {
                    value[i][j] = value[i - 1][j];
                }
            }
        }
        return value[n][W];
    }

}
