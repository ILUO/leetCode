package iluo.search_star;

public class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length,result = -1;
        if(length == 0) return result;
        return search(nums,target,0,length-1);
    }

    private int search(int[] nums,int target,int start,int end){
        if(start == end){
            if(nums[start] == target) return start;
            else return -1;
        }else if(start > end){
            return -1;
        }else{
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            if((nums[mid] >= nums[0] && target > nums[mid]) || (target < nums[mid] && nums[mid] >= nums[0] && nums[0] > target) ||
                    (nums[mid] <= nums[0] && target >nums[mid] && nums[0] > target)){
                return search(nums,target,mid+1,end);
            }else{
                return search(nums,target,start,mid-1);
            }
        }
    }
}
