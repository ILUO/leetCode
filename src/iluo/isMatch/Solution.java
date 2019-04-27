package iluo.isMatch;

public class Solution {
    private boolean result = false;
    public boolean isMatch(String s, String p) {
        isMatchCore(s,p);
        return result;
    }

    private boolean isMatchCore(String s,String p){
        if(s.length() == 0 && p.length() == 0) result = true;
        else if(s.length() != 0 && p.length() == 0) result = false;
        else{
            if(p.length() >= 2){
                if(p.charAt(0) == '.' && p.charAt(1) != '*'){
                    if(s.length() > 0){
                        result = result || isMatchCore(s.substring(1),p.substring(1));
                    }
                }else if(p.charAt(0) == '.' && p.charAt(1) == '*'){
                    result = result || isMatchCore(s,p.substring(2));
                    for(int i = 0;i < s.length();i++){
                        result = result || isMatchCore(s.substring(i+1),p.substring(2));
                    }
                }else if(p.charAt(0) != '.' && p.charAt(0) != '*'){
                    if(p.charAt(1) != '*'){
                        if(s.length() > 0 && p.charAt(0) == s.charAt(0)){
                            result = result || isMatchCore(s.substring(1),p.substring(1));
                        }
                    }else{
                        result = result || isMatchCore(s,p.substring(2));
                        for(int i = 0;i < s.length();i++){
                            if(s.charAt(0) == p.charAt(0) && s.charAt(0) == s.charAt(i)){
                                result = result || isMatchCore(s.substring(i+1),p.substring(2));
                            }else {
                                break;
                            }
                        }
                    }
                }
            }else{
                if(p.length() == 1 && s.length() == 1){
                    if(p.charAt(0) == '.') result = true;
                    if(p.equals(s)) result= true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.isMatch("","");
    }
}
