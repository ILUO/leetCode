package iluo.selfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2019/2/3.
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if(left > right || right <= 0){
            return result;
        }
        if(left <= 0){
            left = 1;
        }
        for(int i = left;i <= right;i++){
            boolean flag = true;
            int temp = i;
            for(;temp != 0;){
                int num = temp % 10;
                if(num != 0 && i % num == 0){
                    temp = temp / 10;
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag) result.add(i);
        }
        return result;
    }
}
