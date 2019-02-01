package iluo.checkPossibility;

/**
 * Created by Yang Xing Luo on 2019/2/1.
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        /**
         * 传递性
         */
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i] > nums[i+1]){
                if( i != 0){
                    /**
                     * 如果i+1个数比i-1个数还要大，让i个数变为i+1个数，可以保证前i+1个顺序是非递减的，但是反过来可能会扰乱i+1之后的顺序。
                     */
                    if(nums[i+1] > nums[i-1]){
                        nums[i] = nums[i+1];
                        break;
                    }else{
                        /**
                         * 如果i+1个数比i-1个数还要小，此时前i+1个已经不是非递减的了，为了优先保证前i+1个数是非递减的，只能先牺牲i+1后面的顺序，让第i+1个数变为第i个数。
                         */
                        nums[i+1] = nums[i];
                        break;
                    }
                }else {
                    nums[i] = nums[i+1];
                    break;
                }
            }
        }
        /**
         * 重新遍历检查
         */
        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums = {2,3,3,2,4};
        System.out.println(solution.checkPossibility(nums));
    }
}
