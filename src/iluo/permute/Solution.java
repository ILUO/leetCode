package iluo.permute;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            numsList.add(nums[i]);
        }
        backTrack(numsList,new ArrayList<>());
        return result;
    }

    private void backTrack(List<Integer> numsList,List<Integer> onePermute){
        if(numsList.size() == 0){
            result.add(onePermute);
            return;
        }
        for(int i = 0;i < numsList.size();i++){
            Integer num = numsList.get(i);
            onePermute.add(num);
            List<Integer> numsListClone = new ArrayList<>(numsList);
            numsListClone.remove(num);
            backTrack(numsListClone,new ArrayList<>(onePermute));
            onePermute.remove(onePermute.size() - 1);
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {0,-1,1};
        solution.permute(a);
    }
}
