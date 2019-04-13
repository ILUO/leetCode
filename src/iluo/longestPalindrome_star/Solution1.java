package iluo.longestPalindrome_star;

public class Solution1 {
    public String longestPalindrome(String s) {
        if(s == null) return "";
        int length = s.length();
        if(length == 0) return s;
        int[][] flag = new int[2][length];
        int start = 0,maxLen = 1;
        int now = 0;
        for(int i = length - 2;i >= 0;i--){
            flag[now][i] = 1;
            for(int j = length - 1;j >= i;j--){
                if(j == i + 1){
                    if(s.charAt(i) == s.charAt(j)){
                        flag[now][j] = 1;
                    }
                }else if(j > i + 1){
                    if(s.charAt(i) == s.charAt(j)){
                        if(flag[1-now][j-1] == 1){
                            flag[now][j] = 1;
                        }
                    }
                }
                if(flag[now][j] == 1 && maxLen < j - i + 1){
                    start = i;
                    maxLen = j - i + 1;
                }
            }
            now = 1 - now;
            for(int k = 0;k < length;k++){
                flag[now][k] = 0;
            }
        }
        return s.substring(start,start+maxLen);
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        solution1.longestPalindrome("圣剑剑圣无敌斩斩敌无数");
    }
}
