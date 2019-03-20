package iluo.maxDistToClosest;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int start = 0;
        int end = 0;
        int result = 1;
        for(int i = 1;i < seats.length;i++){
            if(i == 1 && seats[i-1] == 0){
                start = 0;
            }
            if(seats[i] == 0 && seats[i-1] == 1){
                start = i;
            }
            if(i == seats.length - 1 && seats[i] == 0){
                end = seats.length;
            }
            if(seats[i] == 1 && seats[i-1] == 0){
                end = i;
            }
            int temp = end - start;
            if(start != 0 &&  end != seats.length){
                if(temp % 2 != 0){
                    temp = temp / 2 + 1;
                }else{
                    temp = temp / 2;
                }
            }
            if(result < temp){
                result = temp;
            }

        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {1,0,0,0,1,0,1};
        System.out.println(solution.maxDistToClosest(a));
    }
}
