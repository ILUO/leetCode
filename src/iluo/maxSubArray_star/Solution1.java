package iluo.maxSubArray_star;

public class Solution1 {
    public int maxSubArray(int[] nums){
        int[] max = new int[nums.length];
        int res = max[0];
        max[0] = nums[0];

        for(int i = 1;i < nums.length;i++){
            max[i] = (max[i-1]+max[i]) > max[i] ? max[i-1]+max[i] : max[i];
            if(max[i] > res){
                res = max[i];
            }
        }
        return res;
    }

}
