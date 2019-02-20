package iluo.findUnsortedSubarray_star;

/**
 * Created by Yang Xing Luo on 2019/2/20.
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        for(int countRepeat = 0;i < nums.length - 2;i++){
            if(nums[i] == nums[i+1]){
                countRepeat++;
                continue;
            }else if(nums[i] < nums[i+1]){
                countRepeat = 0;
            }else{
                i -= countRepeat;
                break;
            }
        }
        for(int countRepeat = 0;j > 0;j--){
            if(nums[j] == nums[j-1]){
                countRepeat++;
                continue;
            }else if(nums[j - 1] < nums[j]){
                countRepeat = 0;
            }else{
                j += countRepeat;
                break;
            }
        }
        int result = j - i;
        if(result <= 0) return 0;
        else return result+1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] a= {1,2,4,5,3};
        System.out.println(solution.findUnsortedSubarray(a));
    }
}
