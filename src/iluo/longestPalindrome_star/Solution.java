package iluo.longestPalindrome_star;

public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return "";
        int length = s.length();
        if(length == 0) return s;
        int[][] flag = new int[length][length];
        for(int i = 0;i < length;i++){
            flag[i][i] = 1;
        }
        int start = 0,maxLen = 1;
        for(int i = length - 2;i >= 0;i--){
            for(int j = length - 1;j >= i;j--){
                if(j == i + 1){
                    if(s.charAt(i) == s.charAt(j)){
                        flag[i][j] = 1;
                    }
                }else if(j > i + 1){
                    if(s.charAt(i) == s.charAt(j)){
                        if(flag[i+1][j-1] == 1){
                            flag[i][j] = 1;
                        }
                    }
                }
                if(flag[i][j] == 1 && maxLen < j - i + 1){
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }



    public static void main(String[] args){
        String s  = "bbbb";
        Solution solution = new Solution();
        solution.longestPalindrome(s);
    }
}
