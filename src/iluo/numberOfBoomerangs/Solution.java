package iluo.numberOfBoomerangs;

import java.util.HashMap;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int result = 0;

        for(int i = 0;i < n;i++){
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for(int j = 0;j < n;j++){
                int distance = 0;
                if(i != j){
                    distance= (points[i][0] - points[j][0])*(points[i][0] - points[j][0]) + (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                }
                if(distance != 0){
                    if(hashMap.containsKey(distance)){
                        hashMap.put(distance,hashMap.get(distance)+1);
                    }else{
                        hashMap.put(distance,1);
                    }
                }
            }

            for(Integer key:hashMap.keySet()){
                int num = hashMap.get(key);
                if(num >= 2){
                    result += (num)*(num - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int [][] a = {{0,0},{1,0},{2,0}};
        Solution solution = new Solution();
        System.out.println(solution.numberOfBoomerangs(a));
    }

}
