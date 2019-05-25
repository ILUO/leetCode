package iluo.uniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n];
        for(int i = 0;i < n;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i < m;i++){
            for(int j = 0;j < n;j++){
                if(j == 0) dp[i % 2][j] = 1;
                else dp[i % 2][j] = dp[i % 2][j-1] + dp[1 - i % 2][j];
            }
        }
        if(m % 2 == 0) return dp[1][n - 1];
        else return dp[0][n - 1];
    }
}
