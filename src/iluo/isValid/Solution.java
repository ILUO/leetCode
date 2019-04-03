package iluo.isValid;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.size() == 0) return false;
                if(s.charAt(i) == ')'){
                    if(stack.peek() != '(') return false;
                    else stack.pop();
                }else if (s.charAt(i) == ']'){
                    if(stack.peek() != '[') return false;
                    else stack.pop();
                }else{
                    if(stack.peek() != '{') return false;
                    else stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        solution.isValid("]");
    }
}
