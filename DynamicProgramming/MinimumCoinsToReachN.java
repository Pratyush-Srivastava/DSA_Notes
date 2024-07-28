package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MinimumCoinsToReachN {

    public static void main(String[] args) {
        int n = 43;
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        System.out.println("The minimum denominations used are " + minimumCoins(denominations, n));
    }

    /**
     * Coin Change Problem Where order doesn't matter.
     * {1,2,1} and {1,1,2} are same when order doesn't matter
     */
    private static List<Integer> minimumCoins(int[] denominations, int n) {
        List<List<Integer>> totalCoins = new ArrayList<>();
        totalCoins.add(new ArrayList<>());
        for (int i = 1; i < n + 1; i++) {
            List<Integer> coins = new ArrayList<>();
            int minNumberOfCoins = Integer.MAX_VALUE;
            int minDenomination = Integer.MAX_VALUE;
            for (int denomination : denominations) {
                if (i - denomination >= 0) {
                    if (totalCoins.get(i - denomination).size() + 1 < minNumberOfCoins) {
                        minNumberOfCoins = totalCoins.get(i - denomination).size() + 1;
                        minDenomination = denomination;
                    }
                }
            }
            if (minDenomination != Integer.MAX_VALUE) {
                coins.addAll(totalCoins.get(i - minDenomination));
                coins.add(minDenomination);
            }
            totalCoins.add(coins);
        }
        return totalCoins.get(n);
    }
}
