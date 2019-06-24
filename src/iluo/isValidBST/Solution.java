package iluo.isValidBST;

import iluo.util.TreeNode;

public class Solution {
    private boolean result = true;
    public boolean isValidBST(TreeNode root) {
        result &= isValidCore(root,null,null);
        return result;
    }

    private boolean isValidCore(TreeNode root,Integer min,Integer max){
        if(root == null) return true;
        if(root.left != null && result){
            if(min == null){
                if(root.left.val < root.val) result = result & isValidCore(root.left,null,root.val);
                else result = false;
            }else{
                if(root.left.val < root.val && root.left.val > min) result = result & isValidCore(root.left,min,root.val);
                else result = false;
            }
        }
        if(root.right != null && result){
            if(max == null){
                if(root.right.val > root.val) result = result & isValidCore(root.right,root.val,null);
                else result = false;
            }else {
                if (root.right.val > root.val && root.right.val < max)
                    result = result & isValidCore(root.right, root.val, max);
                else result = false;
            }
        }
        return result;
    }
}
