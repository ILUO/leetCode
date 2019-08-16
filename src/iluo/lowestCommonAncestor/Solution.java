package iluo.lowestCommonAncestor;

import iluo.util.TreeNode;

import java.util.ArrayList;

/**
 * Created by Yang Xing Luo on 2019/8/8.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pre = new ArrayList<>();
        ArrayList<TreeNode> in = new ArrayList<>();
        int prePIdx = 0,preQIdx = 0,inPidx = 0,inQidx = 0,preLeft = 0,inLeft = 0,inRight = 0;

        ergodic(root,pre,in);

        for(int i = 0;i < pre.size();i++){
            if(pre.get(i).val == p.val) prePIdx = i;
            else if(pre.get(i).val == q.val) preQIdx = i;
            if(in.get(i).val == p.val) inPidx = i;
            else if(in.get(i).val == q.val) inQidx = i;
        }
        if(prePIdx > preQIdx){
            preLeft = preQIdx;
        }else{
            preLeft = prePIdx;
        }
        if(inPidx > inQidx){
            inLeft = inQidx;
            inRight = inPidx;
        }else{
            inLeft = inPidx;
            inRight = inQidx;
        }
        for(int i = inLeft+1;i < inRight;i++){
            TreeNode inNode = in.get(i);
            int idx = pre.indexOf(inNode);
            if(idx < prePIdx && idx < preQIdx) return inNode;
        }

        return pre.get(preLeft);
    }


    private void ergodic(TreeNode root,ArrayList<TreeNode> pre,ArrayList<TreeNode> in){
        if(root == null) return;
        pre.add(root);
        ergodic(root.left,pre,in);
        in.add(root);
        ergodic(root.right,pre,in);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] pre = {3,5,6,2,7,4,1,0,8};
        int[] in = {6,5,7,2,4,3,0,1,8};
        TreeNode treeNode = new TreeNode(0);
        TreeNode root = treeNode.reConstructBinaryTree(pre,in);
        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(8);
        TreeNode node = solution.lowestCommonAncestor(root,p,q);
        System.out.println(node.val);
    }
}
