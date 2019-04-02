package iluo.convertToBase7;

public class Solution {
    public String convertToBase7(int num) {
        if(num < 0){
            return "-"+convertCore(-num,"");
        }else if(num > 0){
            return convertCore(num,"");
        }else{
            return "0";
        }
    }

    private String convertCore(int num,String result){
        if(num == 0){
            return result;
        }else{
            return convertCore(num / 7,result) + String.valueOf(num % 7) ;
        }
    }
}
