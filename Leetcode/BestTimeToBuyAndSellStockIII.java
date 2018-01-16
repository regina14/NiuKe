package Leetcode;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int hold1 = Integer.MIN_VALUE;
        int hold2 = Integer.MIN_VALUE;
        int release1 = 0;
        int release2 = 0;

        for (int i = 0; i < prices.length; i++){
            release2 = Math.max(release2, hold2 + prices[i]);
            hold2 = Math.max(hold2, release2 - prices[i]);
            release1 = Math.max(release1, hold1 + prices[i]);
            hold1 = Math.min(hold1, - prices[i]);

        }
        return release2;
    }
}
