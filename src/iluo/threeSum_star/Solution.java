package iluo.threeSum_star;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(nums,0,nums.length-1);
        if(nums.length < 2) return result;
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                int twoSum = nums[i] + nums[j];
                int k = binarySearch(nums,j+1,nums.length,0-twoSum);
                if(k != -1){
                    List<Integer> three = new ArrayList<>();
                    three.add(nums[i]);
                    three.add(nums[j]);
                    three.add(nums[k]);
                    if(!result.contains(three)){
                        result.add(three);
                    }
                }
            }
        }
        return result;
    }

    private void quickSort(int[] nums,int start,int end){
        if(start >= end) return;
        int i = start;
        int j = end + 1 ;
        int comp = nums[start];
        while(true){
            while(nums[++i] <= comp) if(i >= end) break;
            while(nums[--j] >= comp) if(j <= start) break;
            if( i >= j) break;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        int temp = nums[j];
        nums[j] = comp;
        nums[start] = temp;
        quickSort(nums,start,j-1);
        quickSort(nums,j+1,end);
    }

    private int binarySearch(int[] nums,int start,int end,int target){
        if(start >= end){
            if(start >= nums.length || nums[start] != target) return -1;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] < target){
            return binarySearch(nums,mid+1,end,target);
        }else{
            return binarySearch(nums,start,mid-1,target);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] n = {-1, 0, 1, 2, -1, -4};
        solution.threeSum(n);
    }
}
