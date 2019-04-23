package iluo.findAnagrams_star;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int lens = s.length();
        int lenp = p.length();
        if(lens < lenp) return result;
        HashMap<Character,Integer> mapS = new HashMap<>();
        HashMap<Character,Integer> mapP = new HashMap<>();
        for(int i = 0;i < p.length();i++){
            if(mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i),mapS.get(s.charAt(i)) + 1);
            }else{
                mapS.put(s.charAt(i),1);
            }
            if(mapP.containsKey(p.charAt(i))){
                mapP.put(p.charAt(i),mapP.get(p.charAt(i)) + 1);
            }else{
                mapP.put(p.charAt(i),1);
            }
        }
        if(mapP.size() != 0 && mapP.equals(mapS)) result.add(0);
        for(int i = p.length();i < s.length();i++){
            Character key = s.charAt(i-p.length());
            if(mapS.get(key) == 1){
                mapS.remove(key);
            }else{
                mapS.put(key,mapS.get(key) - 1);
            }
            if(mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i),mapS.get(s.charAt(i))+1);
            }else{
                mapS.put(s.charAt(i),1);
            }
            if(mapP.size() != 0 && mapP.equals(mapS)) result.add(i-p.length()+1);
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "aa";
        String p = "bb";
        solution.findAnagrams(s,p);
    }
}
