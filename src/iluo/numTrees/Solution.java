package iluo.numTrees;

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        if(n <= 1) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            for(int j = 0;j <= i-1;j++){
                dp[i] = dp[i] + dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.numTrees(4));
    }
}
