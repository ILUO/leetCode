package iluo.findKthLargest;

/**
 * Created by Yang Xing Luo on 2019/8/5.
 */
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        for(int i = nums.length/2-1;i >= 0;i--){
            buildHead(nums,i,nums.length);
        }
        int result = 0;
        for(int i = nums.length-1;i >= nums.length - k;i--){
            if(i == nums.length - k) result = nums[0];
            else swap(nums,0,i);
            buildHead(nums,0,i);
        }
        return result;

    }


    private void buildHead(int[] nums,int i,int length){
        int temp = nums[i];
        for(int k = 2*i + 1;k < length;k = k*2 + 1){
            if(k + 1 < length && nums[k] < nums[k+1]) k++;
            if(nums[k] > temp){
                nums[i] = nums[k];
                i = k;
            } else break;
        }
        nums[i] = temp;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args){
        Solution1 solution = new Solution1();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums,2));
    }

}
