package DynamicProgramming;

public class NumberOfWaysCoinChange {

    public static void main(String[] args) {
        System.out.println(numberOfWaysToGetSumUsingCoins(new int[] {1, 2, 3}, 4) == 4);
    }

    private static int numberOfWaysToGetSumUsingCoins(int[] coins, int sum) {
        int n = coins.length;
        int[][] ways = new int[coins.length + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            ways[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(j - coins[i-1] >= 0) {
                    ways[i][j] = ways[i][j - coins[i - 1]];
                }
                ways[i][j] += ways[i-1][j];
            }
        }
        return ways[n][sum];
    }
}
