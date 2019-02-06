package iluo.getPermutation;

import java.util.ArrayList;

/**
 * Created by Yang Xing Luo on 2019/2/6.
 */
public class Solution {
    private int count = 0;

    public String getPermutation(int n, int k) {
        int [] a = new int[n];
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0;i < n;i++ ){
            a[i] = i+1;
        }
        permutationCore(a,result,0,a.length-1,k);
        return result.get(result.size()-1);

    }

    private void permutationCore(int[] a,ArrayList<String> result,int start,int end,int k){
        if(start == end){
            String r = "";
            for(int i=0;i < a.length;i++){
                r += String.valueOf(a[i]);
            }
            if(!result.contains(r)){
                result.add(r);
                count++;
            }
        }else {
            for(int i = start;i <= end;i++){
                if(isSwap(a,start,i)){
                    swap(a,start,i);
                    permutationCore(a,result,start+1,end,k);
                    swap(a,start,i);
                }
                if(count == k) return;
            }
        }
    }

    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean isSwap(int[] a,int start,int end){
        for(int i = start;i < end;i++){
            if(a[i] == a[end]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3,5));
    }
}




