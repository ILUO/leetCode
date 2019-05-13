package iluo.rotate;

public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0;i < matrix.length;i++){
            for(int j = i + 1;j < matrix[0].length;j++){
                swap(i,j,j,i,matrix);
            }
        }
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0,k = matrix[i].length-1;j < k;j++,k--){
                swap(i,j,i,k,matrix);
            }
        }
    }

    private void swap(int ix,int iy,int jx,int jy,int[][] matrix){
        int temp = matrix[ix][iy];
        matrix[ix][iy] = matrix[jx][jy];
        matrix[jx][jy] = temp;
    }
}
