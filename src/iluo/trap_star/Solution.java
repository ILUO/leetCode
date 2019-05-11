package iluo.trap_star;

public class Solution {
    public int trap(int[] height){
        int result = 0;
        int maxHeight = -1;
        for(int i = 0;i < height.length;i++){
            if(height[i] > maxHeight) maxHeight = height[i];
        }
        for(int i = maxHeight;i > 0;i--){
            int left = -1,right = -1;
            for(int j = 0;j < height.length;j++){
                if(height[j] >= i && left == right){
                    right = j;
                }else if(height[j] >= i && left > right){
                    left = j;
                }
                if(left < right){
                    if(left != -1){
                        result += right - left - 1;
                    }
                    left = right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] height = {3,1,0,3,1,0,1,13,2,1,2,3};
        solution.trap(height);
    }


}
