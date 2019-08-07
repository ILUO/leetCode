package iluo.maximalSquare;

/**
 * Created by Yang Xing Luo on 2019/8/7.
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int[] dp = new int[col];
        int prev = 0;
        int result = 0;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(matrix[i][j] == '1'){
                    int temp = dp[j];
                    dp[j] = getMin(i,j,dp,prev) + 1;
                    if(result < dp[j]) result = dp[j];
                    prev = temp;
                }else dp[j] = 0;            }
        }
        return result*result;
    }

    private int getMin(int i,int j,int[] dp,int prev){
        int left = 0;
        if(j >= 1) left = dp[j-1];
        int up = dp[j];
        int min = 0;

        if(left < up) min = left;
        else min = up;

        if(prev < min) return prev;
        else return min;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        char[][] a = {{'1','0','1','1','1'},
                      {'0','1','0','1','0'},
                      {'1','1','0','1','1'},
                      {'1','1','0','1','1'},
                      {'0','1','1','1','1'}};
        int r = solution.maximalSquare(a);
        System.out.println(r);
    }
}
