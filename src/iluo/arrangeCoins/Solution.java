package iluo.arrangeCoins;

/**
 * Created by Yang Xing Luo on 2019/2/14.
 */
public class Solution {
    public int arrangeCoins(int n) {
        if(n <= 0){
            return 0;
        }

        long sum = 0;
        int count = 0;
        for(;sum < n;count++){
            sum += count;
        }

        if(sum == n){
            return count - 1;
        }else{
            return count - 2;
        }
    }
}
