package iluo.binaryGap;

public class Solution {
    public int binaryGap(int N) {
        int firstFlag = 0;
        int start = 0;
        int count = 0;
        int end = 0;
        int max = 0;
        for(;N != 0;count++){
            int code = N % 2;
            if(code == 1){
                if(firstFlag == 0){
                    start = count;
                    firstFlag = 1;
                }else{
                    end = count;
                    if(end - start > max){
                        max = end - start;
                    }
                    start = end;
                }
            }
            N = N / 2;
        }
        return max;
    }


}
