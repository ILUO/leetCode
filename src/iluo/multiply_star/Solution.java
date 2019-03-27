package iluo.multiply_star;

public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] value = new int[m + n];
        for(int i = 0;i < num1.length();i++){
            for(int j = 0;j < num2.length();j++){
                value[i + j + 1] += ((int)(num1.charAt(i)) - (int)('0')) * ((int)(num2.charAt(j)) - (int)('0'));
            }
        }

        int carry = 0;
        String result = "";
        for(int i = value.length - 1;i >= 0;i--){
            int val = value[i] % 10 + carry;
            if(val >= 10){
                carry = val / 10 + value[i] / 10;
                value[i] = val % 10;
            }else{
                carry = value[i] / 10;
                value[i] = val;
            }
            result = String.valueOf(value[i]) + result;
        }
        int index = 0;
        for(int i = 0;i < result.length() - 1;i++){
            if(result.charAt(i) == '0'){
                index  = i+1;
            }else{
                break;
            }
        }
        return result.substring(index);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.multiply("123","456");
    }
}
