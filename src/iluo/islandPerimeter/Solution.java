package iluo.islandPerimeter;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int colum = grid[0].length;
        int result = 0;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < colum;j++){
                if(grid[i][j] == 1){
                    if(i > 0){
                        if(grid[i-1][j] == 0) result++;
                    }else{
                        result++;
                    }
                    if(i == row - 1){
                        result++;
                    }
                    if(j > 0){
                        if(grid[i][j-1] == 0) result++;
                    }else{
                        result++;
                    }
                    if(j == colum - 1){
                        result++;
                    }
                }
                if(grid[i][j] == 0){
                    if(i > 0){
                        if(grid[i-1][j] == 1) result++;
                    }
                    if(j > 0){
                        if(grid[i][j-1] == 1) result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] a = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(solution.islandPerimeter(a));
    }
}
