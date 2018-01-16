package Leetcode;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }

        int max = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++){
            if (prices[i + 1] > prices[i]){
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
