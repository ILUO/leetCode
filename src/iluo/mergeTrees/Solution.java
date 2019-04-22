package iluo.mergeTrees;

import iluo.util.TreeNode;

public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return pre(t1,t2);
    }

    private TreeNode pre(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return null;
        else{
            TreeNode node = new TreeNode(0);
            if(t1 != null && t2 != null){
                node.val = t1.val + t2.val;
                node.left = pre(t1.left,t2.left);
                node.right = pre(t1.right,t2.right);
            }else if(t1 == null){
                node.val = t2.val;
                node.left = pre(null,t2.left);
                node.right = pre(null,t2.right);
            }else{
                node.val = t1.val;
                node.left = pre(t1.left,null);
                node.right = pre(t1.right,null);
            }
            return node;
        }
    }
}
