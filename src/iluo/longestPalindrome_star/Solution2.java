package iluo.longestPalindrome_star;

public class Solution2 {
    public String longestPalindrome(String s) {
        if(s == null) return "";
        int length = s.length();
        if(length == 0) return s;
        int start = 0,maxLen = 1;
        for(int i = 1;i < s.length() - 1;i++){
            int left = i - 1;
            int right = i + 1;
            for(;left >= 0 && right <= s.length()-1;left--,right++){
                if(s.charAt(left) == s.charAt(right)){
                    if(maxLen < right - left + 1){
                        start = left;
                        maxLen = right - left + 1;
                    }
                }else{
                    break;
                }
            }
        }
        for(int i = 0;i < s.length() - 1;i++){
            int left = i;
            int right = i + 1;
            for(;left >=0 && right <= s.length()-1;left--,right++){
                if(s.charAt(left) == s.charAt(right)){
                    if(maxLen < right - left + 1){
                        start = left;
                        maxLen = right - left + 1;
                    }
                }else{
                    break;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
