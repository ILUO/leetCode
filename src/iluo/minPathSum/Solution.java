package iluo.minPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[2][width];
        for(int i = 0;i < width;i++){
            if(i == 0) dp[0][0] = grid[0][0];
            else dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1;i < height;i++){
            for(int j = 0;j < width;j++){
                if(j == 0) dp[i%2][j] = dp[1-i%2][j] + grid[i][j];
                else{
                    if(dp[i%2][j-1] > dp[1-i%2][j]) dp[i%2][j] = dp[1-i%2][j] + grid[i][j];
                    else dp[i%2][j] = dp[i%2][j-1] + grid[i][j];
                }
            }
        }
        if(height % 2 == 0)  return dp[1][width-1];
        else return dp[0][width-1];
    }
}
