package iluo.isSymmetric;

import iluo.util.TreeNode;

public class Solution {
    private boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return DFS(root.left,root.right);
    }

    private boolean DFS(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else{
            if(root1 != null && root2 != null){
                if(root1.val == root2.val && res) res &= DFS(root1.left,root2.right) & DFS(root1.right,root2.left);
                else return false;
            }else return false;
        }
        return res;
    }
}
