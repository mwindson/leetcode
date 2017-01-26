package Problem101_200;

/**
 * Created by mwindson on 2017/1/26.
 */
public class Problem121 {
    public static void main(String[] args) {
        int[] prices = {};
        System.out.println(maxProfit(prices));
    }

//   最大子序列算法
//    public int maxProfit(int[] prices) {
//        int maxCur = 0, maxSoFar = 0;
//        for(int i = 1; i < prices.length; i++) {
//            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
//            maxSoFar = Math.max(maxCur, maxSoFar);
//        }
//        return maxSoFar;
//    }
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int buyPrice = prices[0];
        int sellPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (sellPrice < prices[i]) {
                sellPrice = prices[i];
                maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
            }
            if (buyPrice > prices[i]) {
                maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
                buyPrice = prices[i];
                sellPrice = buyPrice;
            }
        }
        return maxProfit;
    }
}
