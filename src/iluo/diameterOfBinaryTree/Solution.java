package iluo.diameterOfBinaryTree;

import iluo.util.TreeNode;

public class Solution {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // if(root != null){
        //     int temp = 1 + getDepth(root.left) + getDepth(root.right);
        //     if(temp > diameter) diameter = temp;
        //     diameterOfBinaryTree(root.left);
        //     diameterOfBinaryTree(root.right);
        // }
        // if(diameter >= 1){
        //     return diameter - 1;
        // }else{
        //     return diameter;
        // }
        getDepth(root);
        return diameter;

    }

    private int getDepth(TreeNode node){
        if(node == null) return 0;
        else{
            int l = getDepth(node.left);
            int r = getDepth(node.right);
            if(diameter < l + r ){
                diameter  = l + r;
            }
            return (l > r ? l : r) + 1;
        }
    }
}
