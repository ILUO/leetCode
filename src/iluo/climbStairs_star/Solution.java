package iluo.climbStairs_star;

public class Solution {
    public int climbStairs(int n) {
        int result1 = 1;
        int result2 = 2;
        int result = 0;
        if(n == 1) return result1;
        if(n == 2) return result2;
        for(int i = 3;i <= n;i++){
            result = result1 + result2;
            result1 = result2;
            result2 = result;
        }
        return result;
    }
}
