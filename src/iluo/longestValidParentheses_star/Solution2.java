package iluo.longestValidParentheses_star;

public class Solution2 {
    public int longestValidParentheses(String s) {
        int length = s.length();
        int[] dp = new int[length+1];
        s = "," + s;
        int max = 0;
        for(int i = 1;i <= length;i++){
            if(s.charAt(i) == '(') dp[i] = 0;
            else if(s.charAt(i) == ')' && i > 1 && s.charAt(i - 1) == '(') dp[i] = dp[i-2] + 2;
            else if(s.charAt(i - dp[i - 1] - 1) == '(') dp[i] = dp[i - 1] + 2 + dp[i - dp[i-1] - 2];
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args){
        Solution2 solution2 = new Solution2();
        solution2.longestValidParentheses("()()())()");
    }
}
