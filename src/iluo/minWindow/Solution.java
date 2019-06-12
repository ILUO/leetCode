package iluo.minWindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        Map<Character,Integer> windowsCount = new HashMap<>();
        Map<Character,Integer> targetCount = new HashMap<>();

        for(int i = 0;i < t.length();i++){
            int count = targetCount.getOrDefault(t.charAt(i),0);
            targetCount.put(t.charAt(i),count + 1);
        }

        int required = targetCount.size();
        int formed = 0;

        int l = 0,r = 0;
        int[] res = {-1,0,0};

        while(r < s.length()){
            Character c = s.charAt(r);
            int count = windowsCount.getOrDefault(s.charAt(r),0);
            windowsCount.put(s.charAt(r),count + 1);
            if(targetCount.containsKey(c) && windowsCount.get(c).intValue() == targetCount.get(c).intValue()){
                formed++;
            }
            while (l <= r && formed == required){
                c = s.charAt(l);
                if(res[0] == -1 || r - l + 1 < res[0]){
                    res[0] = r - l + 1;
                    res[1] = l;
                    res[2] = r;
                }
                windowsCount.put(s.charAt(l),windowsCount.get(c)-1);
                if(targetCount.containsKey(c) && windowsCount.get(c) < targetCount.get(c)) formed--;
                l++;
            }

            r++;
        }
        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC","ABC"));
    }
}
