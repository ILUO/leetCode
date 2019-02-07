package iluo.getPermutation;

import java.util.ArrayList;

/**
 * Created by Yang Xing Luo on 2019/2/6.
 */
public class Solution1 {
    public String getPermutation(int n, int k){
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            arrayList.add(i);
        }
        int factorial = getFactorial(arrayList.size());
        for(;arrayList.size()!=0;){
            factorial = factorial / arrayList.size();
            int index = k / factorial;
            int remain = k % factorial;
            if(remain == 0 && k != 0){
                index--;

            }
            result.add(arrayList.get(index));
            arrayList.remove(index);
            if(remain != 0){
                k = k % factorial;
            }else {
                k = k - index*factorial;
            }

        }
        String resultString = "";
        for(int i = 0;i < result.size();i++){
            resultString += String.valueOf(result.get(i));
        }
        return resultString;
    }

    private int getFactorial(int n){
        if(n == 1){
            return 1;
        }else {
            return n*getFactorial(n-1);
        }
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        System.out.println(solution.getPermutation(3,4));
    }
}
