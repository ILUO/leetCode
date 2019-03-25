package iluo.maxProfit_star;

public class Solution1 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int result = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length;i++){
            if(min > prices[i]) min = prices[i];
            else{
                int temp = prices[i] - min;
                if(temp > result) result = temp;
            }
        }
        return result;
    }
}
