package iluo.findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for(int i = 0;i < length;){
            if(nums[i] == i+1){
                i++;
                continue;
            }
            if(nums[i] == nums[nums[i]-1]) i++;
            else{
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0;i < length;i++){
            if(nums[i] != i+1){
                result.add(i+1);
            }
        }

        return result;
    }
}
