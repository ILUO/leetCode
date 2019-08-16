package iluo.productExceptSelf;

/**
 * Created by Yang Xing Luo on 2019/8/10.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] re = new int[len];
        if(len == 0) return new int[]{0};
        int help = 1;
        for(int i = 0; i < len; i++){
            re[i] = help;
            help *= nums[i];
        }
        help = 1;
        for(int i = len-1; i >= 0; i--){
            re[i] *= help;
            help *= nums[i];
        }
        return re;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,3,4,5};
        solution.productExceptSelf(nums);
    }
}
