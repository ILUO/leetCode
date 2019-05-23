package iluo.canJump_star;

public class Solution {
    public boolean canJump(int[] nums) {
        int curMaxStep = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(curMaxStep < i) return false;
            int temp = i + nums[i];
            if(temp > curMaxStep) curMaxStep = temp;
            if(curMaxStep >= nums.length - 1) return true;
        }
        return curMaxStep >= nums.length -1;
    }

}
