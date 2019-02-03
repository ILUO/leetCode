package iluo.minSubArrayLen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2019/2/2.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int minLen = nums.length + 1;
        int start = 0;
        int end = 0;
        int tempSum = 0;
        for(int i = 0;start < nums.length;){
            if(tempSum >= s){
                end = i-1;
                if(end - start+1 <= minLen) minLen = end - start + 1;
                tempSum = tempSum - nums[start];
                start++;
                if(tempSum < s && end == nums.length - 1) break;
                continue;
            }else if(i == nums.length){
                break;
            }
            if(i < nums.length){
                tempSum += nums[i];
                i++;
            }

        }
        if(minLen != nums.length + 1){
            return minLen;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int s = 213;
        System.out.println(solution.minSubArrayLen(s,nums));
    }

}
