package iluo.nextPermutation_star;

public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int idxOfAsc = -1;
        for(int i = length - 1;i >= 1;i--){
            if(nums[i-1] < nums[i]){
                idxOfAsc = i - 1;
                break;
            }

        }
        if(idxOfAsc != -1){
            for(int i = length - 1;i > idxOfAsc;i--){
                if(nums[i] > nums[idxOfAsc]){
                    exchange(nums,i,idxOfAsc);
                    break;
                }
            }
            for(int start = idxOfAsc + 1,end = length - 1; start < end;start++,end--){
                exchange(nums,start,end);
            }
        }else{
            for(int start = 0,end  = length - 1;start < end;start++,end--){
                exchange(nums,start,end);
            }
        }
    }

    private void exchange(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        solution.nextPermutation(nums);
    }
}
