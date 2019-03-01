package iluo.reverse;


public class Solution {
    public int reverse(int x) {
        int[] code = new int[10];
        long newX = x;
        if(x < 0) newX = 0 - x;
        int count = getCode(code,newX,0);
        long  result = 0;
        for(int i = 0;i < count;i++){
            result += code[i]*Math.pow(10,count-i-1);
        }
        if(x < 0) result = -result;
        if(result > 2147483647 || result < -2147483648) return 0;
        else return (int)result;
    }

    private int getCode(int[] code,long newX,int count){
        if(newX == 0) return count;
        else{
            code[count] = (int)(newX % 10);
            return getCode(code,newX/10,count+1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverse(-120));
    }
}
