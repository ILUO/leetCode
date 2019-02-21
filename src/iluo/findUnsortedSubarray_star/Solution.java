package iluo.findUnsortedSubarray_star;

/**
 * Created by Yang Xing Luo on 2019/2/20.
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int min = nums[length - 1];
        int start = -1;
        for(int i = nums.length - 1;i >= 0;i--){
            if(nums[i] > min){
                start = i;
            }else {
                min = nums[i];
            }
        }

        if(start == -1) return 0;

        int max = nums[0];
        int end = 0;
        for(int i = 0;i <= nums.length - 1;i++){
            if(nums[i] < max){
                end = i;
            }else{
                max = nums[i];
            }
        }
        return end - start + 1;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a= {1,2,4,5,3};
        System.out.println(solution.findUnsortedSubarray(a));
    }
}
