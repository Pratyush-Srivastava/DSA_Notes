package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuyAndSell {
    public static void main(String[] args) {
        System.out.println(maxStockBuyAndSell(Arrays.asList(1, 5, 3, 8, 12)));
        System.out.println(maxStockBuyAndSell(Arrays.asList(30, 20, 10)));
        System.out.println(maxStockBuyAndSell(Arrays.asList(10, 20, 30)));
        System.out.println(maxStockBuyAndSell(Arrays.asList(1, 5, 3, 1, 2, 8)));
        List<Integer> a = new ArrayList<>();

    }

    private static int maxStockBuyAndSell(List<Integer> prices) {
        int maxProfit = 0;
        int max = prices.get(0);
        for (int price : prices) {
            if (price > max) {
                maxProfit = maxProfit + price - max;
            }
            max = price;
        }
        return maxProfit;
    }
}
