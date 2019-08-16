package iluo.searchMatrix;

/**
 * Created by Yang Xing Luo on 2019/8/13.
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        for(int i = m - 1,j = 0;i >=0 && j < n;){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) j++;
            else i--;
        }
        return false;
    }
}
