package iluo.prisonAfterNDays;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[][] state = new int[14][8];
        for(int i = 0;i < 14;i++){
            for(int j = 0;j < 8;j++){
                if(j == 0 || j == 7) state[i][j] = 0;
                else{
                    if(cells[j-1] == cells[j+1]) state[i][j] = 1;
                    else state[i][j] = 0;
                }
            }
            cells = state[i];
        }
        int index = N % 14;
        return state[index-1];
    }
    public static void main(String[] args){
        int [] a = {0,1,0,1,1,0,0,1};
        Solution solution = new Solution();
        solution.prisonAfterNDays(a,7);
    }
}
