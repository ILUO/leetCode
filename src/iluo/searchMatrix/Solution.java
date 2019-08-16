package iluo.searchMatrix;

/**
 * Created by Yang Xing Luo on 2019/8/13.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        int loop = (m > n) ? n : m;
        for(int i = 0;i < loop;i++){
            if(res) break;
            res = rowSearch(i,i,n-1,matrix,target);
            if(res) break;
            res = colSearch(i,i,m-1,matrix,target);
        }
        return res;
    }


    private boolean rowSearch(int i,int start,int end,int [][] matrix,int target){
        if(start > end) return false;
        int mid = (start + end) / 2;
        if(matrix[i][mid] == target) return true;
        else if(matrix[i][mid] > target) return rowSearch(i,start,mid-1,matrix,target);
        else return rowSearch(i,mid+1,end,matrix,target);
    }

    private boolean colSearch(int j,int start,int end,int [][] matrix,int target){
        if(start > end) return false;
        int mid = (start + end) / 2;
        if(matrix[mid][j] == target) return true;
        else if(matrix[mid][j] > target) return colSearch(j,start,mid-1,matrix,target);
        else return colSearch(j,mid+1,end,matrix,target);
    }
}
