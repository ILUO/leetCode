package iluo.generateParenthesis_star;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(0,0,"",res,n);
        return res;

    }

    private void backTrack(int count1,int count2,String ans,List<String> res,int n){
        if(count1 > n || count2 > n) return;
        if(count1 == n && count2 == n) res.add(ans);
        if(count1 >= count2){
            String ans1 = new String(ans);
            backTrack( count1+1, count2,ans+"(",res, n);
            backTrack(count1, count2+1,ans+")",res, n);
        }
    }
}
