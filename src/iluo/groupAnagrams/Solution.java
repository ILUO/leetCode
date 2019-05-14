package iluo.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            int[] alphaBeta = new int[26];
            for(int j = 0;j < strs[i].length();j++){
                alphaBeta[strs[i].charAt(j) - 97]++;
            }
            String key = "";
            for(int j = 0;j < alphaBeta.length;j++){
                if(alphaBeta[j] != 0){
                    key += String.valueOf((char) (j+97))+ alphaBeta[j];
                }
            }
            if(hashMap.containsKey(key)){
                List<String> group = hashMap.get(key);
                group.add(strs[i]);
                hashMap.put(key,group);
            }else{
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                hashMap.put(key,group);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String key:hashMap.keySet()){
            result.add(hashMap.get(key));
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] a = {"eat","tea","tan","ate","nat","bat"};
        solution.groupAnagrams(a);
    }
}
