package iluo.intersection;

import java.util.ArrayList;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        quickSort(nums1,0,nums1.length-1);
        for(int i = 0;i < nums2.length;i++){
            if(binarySearch(nums1,nums2[i],0, nums1.length-1)){
                if(!result.contains(nums2[i])){
                    result.add(nums2[i]);
                }
            }
        }
        int[] r = new int[result.size()];
        for(int i = 0;i < result.size();i++){
            r[i] = result.get(i);
        }
        return r;
    }

    private void quickSort(int[] nums,int low,int high){
        if(low  >= high){
            return;
        }
        int i = low;
        int j = high + 1;
        int comp = nums[low];
        while(true){
            while(nums[++i] <= comp) if(i == high) break;
            while(nums[--j] >= comp) if(j == low) break;
            if(i >= j) break;
            else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[j];
        nums[j] = nums[low];
        nums[low] = temp;
        quickSort(nums,low,j-1);
        quickSort(nums,j+1,high);
    }

    private boolean binarySearch(int[] nums,int target,int low,int high){
        if(nums.length < 1) return false;
        if(low >= high){
            if(low >= 0 && low < nums.length && high >= 0 && high < nums.length){
                if(nums[low] != target && nums[high] != target) return false;
                else return true;
            }else {
                return false;
            }
        }
        int mid = (low + high) / 2;
        if(nums[mid] == target) return true;
        else if(nums[mid] > target) return binarySearch(nums,target,low,mid-1);
        else return binarySearch(nums,target,mid+1,high);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] a = solution.intersection(nums1,nums2);
        System.out.println(a);
    }
}
