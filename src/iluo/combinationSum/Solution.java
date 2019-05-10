package iluo.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates,target,new ArrayList<>(),0);
        return result;
    }

    private void backTrack(int[] candidates,int target, List<Integer> combination,int start){
        if(target == 0) result.add(combination);
        else{
            for(int i = start;i < candidates.length;i++){
                if(target - candidates[i] >= 0){
                    start = i;
                    combination.add(candidates[i]);
                    backTrack(candidates,target - candidates[i],new ArrayList<>(combination),start);
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {2,3,5};
        solution.combinationSum(nums,8);
    }
}
