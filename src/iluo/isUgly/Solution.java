package iluo.isUgly;

public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        for(int i = 1;;i++){
            if(num % Math.pow(5,i) == 0) continue;
            else{
                num = num / (int)(Math.pow(5,i-1));
                break;
            }
        }
        for(int i = 1;;i++){
            if(num % Math.pow(3,i) == 0) continue;
            else{
                num = num / (int)(Math.pow(3,i-1));
                break;
            }
        }
        for(int i = 1;;i++){
            if(num % Math.pow(2,i) == 0) continue;
            else{
                num = num / (int)(Math.pow(2,i-1));
                break;
            }
        }
        return num==1;
    }
}
