package iluo.rob;

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        if(length >= 2){
            dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        }
        for(int i = 2;i < nums.length;i++){
            dp[i] = nums[i]+dp[i - 2] > dp[i - 1] ? nums[i]+dp[i - 2] : dp[i - 1];
        }
        return dp[length - 1];
    }
}
