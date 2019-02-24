package iluo.findTheDifference;

public class Solution {
    public char findTheDifference(String s, String t) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            count1[c - 65]++;
        }
        for(int i = 0;i < t.length();i++){
            char c = t.charAt(i);
            count2[c - 65]++;
        }
        int flag = 0;
        for(int i = 0;i < count1.length;i++){
            if(count1[i] != count2[i]){
                flag = i;
                break;
            }
        }
        return (char)(65 + flag);
    }
}
