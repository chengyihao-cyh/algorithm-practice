package org.review2025springAgain.ch08_greedy;

public class T4_maxProfit {
    public int maxProfit(int[] prices) {
        int maxVal = 0;
        int currVal;
        for (int i = 1; i < prices.length; i++) {
            currVal = prices[i] - prices[i - 1];
            maxVal += Math.max(currVal, 0);
        }
        return maxVal;
    }
}
