package iluo.numSubarrayProductLessThanK_star;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int result = 0;
        int prod = 1;
        int length = nums.length;
        while(end < length){
            prod *= nums[end++];
            while(start < end && prod >= k){
                prod /= nums[start++];
            }
            result += end - start;
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int a[] = {10,5,2,6};
        solution.numSubarrayProductLessThanK(a,100);
    }
}
