package iluo.numSquares;

/**
 * Created by Yang Xing Luo on 2019/8/14.
 */
public class Solution {
    public int numSquares(int n) {
        int a = (int)Math.sqrt(n);
        if(a == 0) return 0;
        int [][] res = new int[a+1][n+1];
        for(int i = 0;i < n+1;i++) res[0][i] = Integer.MAX_VALUE;
        for(int i = 1;i < a+1;i++) res[i][0] = 0;
        numsSquareCore(res,n,a);
        return res[a][n];
    }


    private int numsSquareCore(int [][] res,int n,int i){
        if(i == 1){
            res[i][n] = n;
            return n;
        }
        if((n - i*i) >= 0){
            res[i][n] = Math.min(numsSquareCore(res,n,i-1),numsSquareCore(res,n-i*i,i)+1);
        }else res[i][n] = numsSquareCore(res,n,i-1);
        return res[i][n];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int res = solution.numSquares(-100);
        System.out.println(res);
    }
}
