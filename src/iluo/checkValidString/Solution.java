package iluo.checkValidString;

import java.util.Stack;

public class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        return checkCore(s,stack,0,false);
    }

    private boolean checkCore(String s,Stack<Character> stack,int i,boolean flag){
        if(flag) return flag;
        if(i == s.length()){
            if(stack.size() == 0) return true;
            else return false;
        }
        if(s.charAt(i) != '*'){
            if(s.charAt(i) == '('){
                stack.push('(');
                flag = checkCore(s,stack,i+1,flag);
                stack.pop();
            }else {
                if (stack.size()!= 0 ){
                    if(stack.peek() == '('){
                        stack.pop();
                        flag = checkCore(s, stack, i + 1,flag);
                        stack.push('(');
                    }
                }
            }
        }else {
            flag = checkCore(s,stack,i+1,flag);

            stack.push('(');
            flag = flag || checkCore(s,stack,i+1,flag);

            stack.pop();
            if(stack.size() !=0){
                if(stack.peek() == '('){
                    stack.pop();
                    flag = flag || checkCore(s,stack,i+1,flag);
                    stack.push('(');
                }

            }
            return flag;
        }
        return flag;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "(*()";
        System.out.println(solution.checkValidString(s));
    }

}
