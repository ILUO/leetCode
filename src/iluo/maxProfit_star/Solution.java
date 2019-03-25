package iluo.maxProfit_star;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int result = 0;
        int[] dp = new int[prices.length];
        for(int i = 1;i < prices.length;i++){
            int temp = prices[i] - prices[i - 1] + dp[i - 1];
            if(temp > 0) dp[i] = temp;
            if(dp[i] > result) result = temp;
        }
        return result;
    }
}
