package iluo.longestValidParentheses_star;

import java.util.Stack;

public class Solution1 {
    public int longestValidParentheses(String s) {
        int left = getValidPartentgeses(s,'(',0,s.length(),1);
        int right = getValidPartentgeses(s,')',s.length()-1,-1,-1);
        return left > right ? left :right;
    }

    private int getValidPartentgeses(String s,Character symbol,int start,int end,int flag){
        int max = 0,temp = 0,sum = 0,valid = 0;
        for(int i = start; i != end;i += flag){
            sum += s.charAt(i) == symbol ? 1 : -1;
            temp++;
            if(sum < 0){
                max = max  > valid ? max : valid;
                sum = 0;
                temp = 0;
                valid = 0;
            }else if(sum == 0){
                valid = temp;
            }
        }
        return max > valid ? max : valid;
    }
}
