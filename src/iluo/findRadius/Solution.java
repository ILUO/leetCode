package iluo.findRadius;

import java.util.Arrays;

/**
 * Created by Yang Xing Luo on 2019/2/8.
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int R = 0;
        for(int i = 0;i < houses.length;i++){
            int tempR = 0;
            int[] result = new int[2];
            int houseLocation = houses[i];
            if(houseLocation < heaters[0]){
                tempR = heaters[0] - houseLocation;
            }else if(houseLocation > heaters[heaters.length-1]){
                tempR = houseLocation - heaters[heaters.length-1];
            }else {
                int start = 0,end = heaters.length-1;
                getLocation(houseLocation,heaters,result,start,end);
                if(result[0] == result[1]){
                    tempR = 0;
                }else {
                    int lr = houseLocation - heaters[result[0]];
                    int rr = heaters[result[1]] - houseLocation;
                    if(lr > rr){
                        tempR = rr;
                    }else {
                        tempR = lr;
                    }
                }
            }
            if(tempR > R){
                R = tempR;
            }
        }
        return R;
    }

    private void getLocation(int housesLocation,int[] heaters,int[] result,int start,int end){
        if(end - start <= 1){
            result[0] = start;
            result[1] = end;
            return;
        }
        int mid = (start + end) / 2;
        if(housesLocation < heaters[mid]) end = mid;
        else if(housesLocation > heaters[mid]) start = mid;
        else start = end = mid;
        getLocation(housesLocation,heaters,result,start,end);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] houses = {1,999};
        int [] heaters = {499,500,501};
        System.out.println(solution.findRadius(houses,heaters));
    }
}
