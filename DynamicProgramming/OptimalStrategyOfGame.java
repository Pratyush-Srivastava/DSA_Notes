package DynamicProgramming;

public class OptimalStrategyOfGame {

    public static void main(String[] args) {
        int[] arr = {9, 1, 2};
        System.out.println(optimalStrategyOfGame(arr) == 10);
        arr = new int[]{5, 3, 7, 10};
        System.out.println(optimalStrategyOfGame(arr) == 15);
        arr = new int[]{8, 15, 3, 7};
        System.out.println(optimalStrategyOfGame(arr) == 22);
    }

    private static int optimalStrategyOfGame(int[] arr) {
        int n = arr.length;
        int[][] maxAmount = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (n % 2 != 0) {
                maxAmount[i][i] = arr[i];
            }
        }
        boolean aTurn = (n % 2 == 0);
        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i + diff < n; i++) {
                int j = i + diff;
                if (aTurn) {
                    maxAmount[i][j] = Math.max(arr[i] + maxAmount[i + 1][j], arr[j] + maxAmount[i][j - 1]);
                } else {
                    maxAmount[i][j] = Math.min(maxAmount[i + 1][j], maxAmount[i][j - 1]);
                }
            }
            aTurn = !aTurn;
        }
        return maxAmount[0][n - 1];
    }

}
