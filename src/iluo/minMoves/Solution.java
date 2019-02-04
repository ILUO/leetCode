package iluo.minMoves;

/**
 * Created by Yang Xing Luo on 2019/2/4.
 */
public class Solution {
    private int step = 0;
    public int minMoves(int[] nums){
        if(isEqual(nums)){
            return step;
        }
        if(nums.length > 1){
            int maxIdx = 0;
            int secondIdx = 1;
            if(nums[0] > nums[1]){
                maxIdx = 0;
                secondIdx = 1;
            }else {
                maxIdx = 1;
                secondIdx = 0;
            }
            for(int i = 2;i < nums.length;i++){
                if(nums[i] > nums[maxIdx]){
                    secondIdx = maxIdx;
                    maxIdx = i;
                }else if(nums[i] > nums[secondIdx]){
                    secondIdx = i;
                }
            }
            int[] idx = {maxIdx,secondIdx};
            while(!isEqual(nums)){
                addOne(nums,idx);
            }
        }
        return step;
    }


    private void addOne(int[] nums,int []idx){
        int max = idx[0];
        for(int i = 0; i < nums.length;i++){
            if(i != max){
                nums[i]++;
                if(nums[i] > nums[idx[0]]){
                    idx[1] = idx[0];
                    idx[0] = i;
                }else if(nums[i] > nums[idx[1]]){
                    idx[1] = i;
                }
            }
        }

        if(nums[idx[0]] < nums[idx[1]]){
            int temp = idx[0];
            idx[0] = idx[1];
            idx[1] = temp;
        }
        step++;
    }

    private boolean isEqual(int[] nums){
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] != nums[i+1]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[] a = {1,1,2147483647};
        Solution solution = new Solution();
        System.out.println(solution.minMoves(a));
    }
}
