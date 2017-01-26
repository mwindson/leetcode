package Problem101_200;

/**
 * Created by mwindson on 2017/1/26.
 */
public class Problem122 {
    public static void main(String[] args) {
        int[] prices = {1, 6, 2, 4, 5, 6};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i];
        }

        return total;
    }
}
