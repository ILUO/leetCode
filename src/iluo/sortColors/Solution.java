package iluo.sortColors;

/**
 * Created by Yang Xing Luo on 2019/6/6.
 */
public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        int start = 0,end = nums.length - 1;
        for(int i = 0;i <= end;i++){
            if(nums[i] == 0){
                exchange(start,i,nums);
                start++;
            }else if(nums[i] == 2){
                exchange(i,end,nums);
                i--; //遇到2和end交换后不知道交换了什么到i的地方
                end--;
            }
        }
    }


    private void exchange(int start,int end,int[] nums){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,0,1};
        solution.sortColors(nums);
    }
}
