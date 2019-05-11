package iluo.trap_star;

public class Solution2 {
    public int trap(int[] height){
        int result = 0;
        int maxHeight = -1,maxIndex = 0;
        for(int i = 0;i < height.length;i++){
            if(height[i] > maxHeight){
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        int temp = height[0];
        for(int i = 0;i < maxIndex;i++){
            if(temp < height[i]) temp = height[i];
            else result += temp - height[i];
        }
        temp = height[height.length-1];
        for(int i = height.length-1;i > maxIndex;i--){
            if(temp < height[i]) temp = height[i];
            else result += temp - height[i];
        }
        return result;
    }

    public static void main(String[] args){
        Solution2 solution2 = new Solution2();
        int[] height = {3,1,0,3,1,0,1,13,2,1,2,3};
        solution2.trap(height);
    }
}
