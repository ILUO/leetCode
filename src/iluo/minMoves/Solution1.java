package iluo.minMoves;

/**
 * Created by Yang Xing Luo on 2019/2/5.
 */
public class Solution1 {
    public int minMoves(int[] nums){
        int sum = 0,minval = 2147483647;
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(minval > nums[i]){
                minval = nums[i];
            }
        }
        return sum - minval*nums.length;
    }

}
