package iluo.searchMatrix;

/**
 * Created by Yang Xing Luo on 2019/8/13.
 */
public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        return searchCore(matrix,0,0,m-1,n-1,target);
    }

    private boolean searchCore(int[][] matrix,int lefti,int leftj,int righti,int rightj,int target){
        if(lefti > righti || leftj > rightj) return false;
        if(target < matrix[lefti][leftj] || target > matrix[righti][rightj]) return false;
        int mid = (leftj + rightj) / 2;
        int i = lefti;
        for(;i <= righti;i++){
            if(matrix[i][mid] == target) return true;
            if(matrix[i][mid] > target) break;
        }
        return searchCore(matrix,i,leftj,righti,mid-1,target) || searchCore(matrix,lefti,mid+1,i-1,rightj,target);
    }

    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int [][] a = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        boolean res = solution1.searchMatrix(a,23);
        System.out.println(res);
    }
}
