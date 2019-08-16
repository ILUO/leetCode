package iluo.numSquares;

/**
 * Created by Yang Xing Luo on 2019/8/14.
 */
public class Solution1 {
    public int numSquares(int n) {
        int a = (int)Math.sqrt(n);
        if(a == 0) return 0;
        int [][] res = new int[a+1][n+1];
        for(int i = 0;i < n+1;i++) res[0][i] = Integer.MAX_VALUE;
        for(int i = 1;i < a+1;i++) res[i][0] = 0;
        for(int i = 1;i < a+1;i++){
            for(int j = 1;j < n+1;j++){
                if((j - i*i) >= 0){
                    res[i][j] = Math.min(res[i-1][j],res[i][j-i*i]+1);
                }else res[i][j] = res[i-1][j];
            }
        }
        return res[a][n];
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        int res = solution.numSquares(13);
        System.out.println(res);
    }
}
