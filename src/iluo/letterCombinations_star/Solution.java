package iluo.letterCombinations_star;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private HashMap<Character,String> table = new HashMap<>();
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        table.put('2',"abc");
        table.put('3',"def");
        table.put('4',"ghi");
        table.put('5',"jkl");
        table.put('6',"mno");
        table.put('7',"pqrs");
        table.put('8',"tuv");
        table.put('9',"wxyz");
        if(digits.length() == 0) return res;
        backTrack(digits,new StringBuffer(),0);
        return res;
    }


    private void backTrack(String digits,StringBuffer temp,int cnt){
        if(cnt >= digits.length()){
            res.add(new String(temp.toString()));
            return;
        }
        for(int i = 0;i < table.get(digits.charAt(cnt)).length();i++){
            backTrack(digits,temp.append(table.get(digits.charAt(cnt)).charAt(i)),cnt+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
