package iluo.moveZeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int j = 0;
        for(int i = 0;i < length;i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for(;j < length;j++){
            nums[j] = 0;
        }
    }
}
