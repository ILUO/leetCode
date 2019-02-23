package iluo.checkValidString_star;

import java.util.Stack;

public class Solution1 {
    public boolean checkValidString(String s) {
        Stack<Character> left = new Stack<>();
        Stack<Character> star1 = new Stack<>();

        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                left.push(s.charAt(i));
            }else if(s.charAt(i) == '*'){
                star1.push(s.charAt(i));
            }else {
                if(left.size() != 0) left.pop();
                else if(star1.size() != 0) star1.pop();
                else return false;
            }
        }

        Stack<Character> right = new Stack<>();
        Stack<Character> star2 = new Stack<>();

        for(int i = s.length()-1;i >= 0;i--){
            if(s.charAt(i) == ')'){
                right.push(s.charAt(i));
            }else if(s.charAt(i) == '*'){
                star2.push(s.charAt(i));
            }else {
                if(right.size() != 0) right.pop();
                else if(star2.size() != 0) star2.pop();
                else return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        String s = "";
        System.out.println(solution1.checkValidString(s));
    }

}
