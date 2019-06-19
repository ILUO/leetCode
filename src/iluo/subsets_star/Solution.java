package iluo.subsets_star;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            numList.add(nums[i]);
        }
        for(int i = 0;i <= nums.length;i++){
            backTrack(res,numList,new ArrayList<>(),i,0);
        }
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> numList, List<Integer> subSet, int length,int start){
        if(length == 0){
            res.add(subSet);
            return;
        }
        for(int i = start;i <= numList.size() - length ;i++){
            subSet.add(numList.get(i));
            backTrack(res,numList,new ArrayList<>(subSet),length-1,i+1);
            subSet.remove(subSet.size()-1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {1,2,3};
        solution.subsets(a);
    }
}
