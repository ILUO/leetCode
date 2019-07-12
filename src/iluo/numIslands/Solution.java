package iluo.numIslands;

/**
 * Created by Yang Xing Luo on 2019/7/11.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int hight = grid.length;
        if(hight == 0) return res;
        int width = grid[0].length;
        int[][] isSearch = new int[hight][width];
        for(int i = 0;i < hight;i++){
            for(int j = 0;j < width;j++){
                if(grid[i][j] == '1' && isSearch[i][j] != 1){
                    search(i,j,grid,isSearch,hight,width);
                    res++;
                }
            }
        }
        return res;
    }

    private void search(int i,int j,char[][] grid,int isSearch[][],int hight,int width){
        if(i < 0 || i >= hight || j < 0 || j >= width || grid[i][j] == '0' || isSearch[i][j] == 1) return;
        isSearch[i][j] = 1;
        search(i-1,j,grid,isSearch,hight,width);
        search(i+1,j,grid,isSearch,hight,width);
        search(i,j-1,grid,isSearch,hight,width);
        search(i,j+1,grid,isSearch,hight,width);
    }


    public static void main(String[] args){
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solution solution = new Solution();
        char[][] grid1 = {};
        solution.numIslands(grid1);
    }
}
