package iluo.containsNearbyAlmostDuplicate_star;

import java.util.ArrayList;

/**
 * Created by Yang Xing Luo on 2019/2/17.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k <= 0 || t < 0) return false;
        if(nums.length <= k+1){
            sort(nums,0,nums.length-1);
            for(int i = 1;i < nums.length;i++){
                if((long)nums[i] - nums[i-1] <= t) return true;
            }
            return false;
        }else {
            int[] knums = new int[k+1];
            for(int i = 0;i <= k;i++) knums[i] = nums[i];
            sort(knums,0,knums.length - 1);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0;i < knums.length;i++) arrayList.add(knums[i]);
            for(int i = 1;i < arrayList.size();i++){
                if((long)arrayList.get(i)-arrayList.get(i-1) <= t) return true;
            }
            for(int i = k+1;i < nums.length;i++){
                arrayList.remove((Integer)nums[i-k-1]);
                int temp = nums[i];
                binaryInsert(arrayList,0,arrayList.size()-1,temp);
                for(int j = 1;j < arrayList.size();j++){
                    if((long)arrayList.get(j)-arrayList.get(j-1) <= t) return true;
                }
            }
        }
        return false;
    }

    private void binaryInsert(ArrayList<Integer> arrayList,int low,int high,int temp){
        if(low >= high){
            if(temp > arrayList.get(low)){
                arrayList.add(low+1,temp);
            }else {
                arrayList.add(low,temp);
            }
            return;
        }
        int mid = (low + high) / 2;
        if(arrayList.get(mid) <= temp){
            binaryInsert(arrayList,mid+1,high,temp);
        }else {
            binaryInsert(arrayList,low,mid-1,temp);
        }
    }

    private void sort(int [] array,int low,int high){
        if(low  >= high){
            return;
        }
        int i = low;
        int j = high + 1;
        int comparable = array[low];
        while(true){
            while(array[++i] <= comparable) if(i == high) break;
            while(array[--j] >= comparable) if(j == low) break;
            if(i >= j){
                break;
            }
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        int temp = array[j];
        array[j] = array[low];
        array[low] = temp;
        sort(array,low,j - 1);
        sort(array,j + 1,high);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {-1,2147483647};
        System.out.println(solution.containsNearbyAlmostDuplicate(a,1,0));
    }
}
