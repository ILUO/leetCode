package iluo.minWindow_star;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yang Xing Luo on 2019/6/9.
 */
public class Solution {
    public String minWindow(String s, String t) {
        ArrayList<Integer> indexList = new ArrayList<>();
        ArrayList<Character> characterList = new ArrayList<>();
        String result = "";
        for(int i=0;i < s.length();i++){
            Character c = s.charAt(i);
            if(t.contains(c.toString())){
                if(!characterList.contains(c)){
                    characterList.add(c);
                    indexList.add(i);
                }else{
                    indexList.remove((characterList.indexOf(c)));
                    characterList.remove(c);
                    characterList.add(c);
                    indexList.add(i);
                }
                if(indexList.size() == t.length()){
                    String tempRes = s.substring(indexList.get(0),indexList.get(indexList.size()-1)+1);
                    if(result.equals("")){
                        result = tempRes;
                    }else if(tempRes.length() < result.length()){
                        result = tempRes;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minWindow("aa","aa"));
    }
}
