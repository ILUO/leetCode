package iluo.isLongPressedName;

/**
 * Created by Yang Xing Luo on 2019/2/19.
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() == 0 && typed.length()!=0 || name.length() !=0 && typed.length()==0) return false;
        if(name.length() == 1){
            for(int i = 0;i < typed.length();i++){
                if(name.charAt(0) != typed.charAt(i)){
                    return false;
                }
            }
            return true;
        }
        int indexOfTyped = 0;
        for(int  i = 0;i < name.length()-1;i++){
            if(name.charAt(i) != name.charAt(i+1)){
                if(name.charAt(i) != typed.charAt(indexOfTyped)) return false;
                for(;indexOfTyped < typed.length() && name.charAt(i) == typed.charAt(indexOfTyped);) indexOfTyped++;
            }else {
                if(name.charAt(i) != typed.charAt(indexOfTyped)) return false;
                indexOfTyped++;
            }
            if(i < name.length()-1 && indexOfTyped >= typed.length()) return false;
        }
        for(;indexOfTyped < typed.length();indexOfTyped++){
            if(name.charAt(name.length()-1) != typed.charAt(indexOfTyped)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName("alex","aaleex"));
    }
}
