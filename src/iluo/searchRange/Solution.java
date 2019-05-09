package iluo.searchRange;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums == null) return result;
        int loc = binarySearch(nums,0, nums.length - 1,target);
        if(loc != -1){
            result[0] = loc;
            result[1] = loc;
            int loc1 = loc,loc2 = loc;
            while(loc1 != -1){
                loc1 = binarySearch(nums,0,loc1-1,target);
                if(loc1 != -1){
                    result[0] = loc1;
                }
            }
            while(loc2 != -1){
                loc2 = binarySearch(nums,loc2+1,nums.length-1,target);
                if(loc2 != -1){
                    result[1] = loc2;
                }
            }
        }
        return result;
    }

    private int binarySearch(int[] nums,int start,int end,int target){
        if(start == end){
            if(nums[start] == target) return start;
            else return -1;
        }else if(start > end){
            return -1;
        }else{
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) return binarySearch(nums,start,mid - 1,target);
            else return binarySearch(nums,mid+1,end,target);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {5,7,7,7,7,7,7,7,7,7,8,8,10};
        solution.searchRange(nums,7);
    }
}
