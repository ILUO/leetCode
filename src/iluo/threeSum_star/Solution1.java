package iluo.threeSum_star;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        quickSort(nums,0,nums.length-1);
        if(nums.length < 2) return result;
        for(int i = 0;i < nums.length;i++){
            int num = nums[i];
            if(i > 0){
                if(nums[i] == nums[i-1]) continue;
            }
            for(int j = i+1,k = nums.length-1;j < k && j < nums.length && k < nums.length;){
                if(nums[j] + nums[k] == -num){
                    List<Integer> three = new ArrayList<>();
                    three.add(nums[i]);
                    three.add(nums[j]);
                    three.add(nums[k]);
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    result.add(three);
                    j++;
                    k--;
                }else if(nums[j] + nums[k] < -num){
                    while(j < k && nums[j] == nums[j+1]) j++;
                    j++;
                }else{
                    while(j < k && nums[k] == nums[k-1]) k--;
                    k--;
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

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int[] n = {-1, 0, 1, 2, -1, -4};
        solution1.threeSum(n);
    }
}
