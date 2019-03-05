package iluo.maxSubArray_star;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tempSum = nums[0];

        for(int i = 1;i < nums.length;i++){
            if(tempSum < 0){
                tempSum = nums[i];
            }else{
                tempSum += nums[i];
            }
            if(tempSum > max){
                max = tempSum;
            }
        }
        return max;
    }
}
