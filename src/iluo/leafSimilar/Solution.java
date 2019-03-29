package iluo.leafSimilar;

import iluo.util.TreeNode;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Integer> leaves1 = new ArrayList<>();
    private ArrayList<Integer> leaves2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        DFS(root1,leaves1);
        DFS(root2,leaves2);
        if(leaves1.size() != leaves2.size()) return false;
        else{
            for(int i = 0;i < leaves1.size();i++){
                if(leaves1.get(i) != leaves2.get(i)) return false;
            }
        }
        return true;
    }

    private void DFS(TreeNode root, ArrayList<Integer> leaves){
        if(root == null) return;
        if(root.left == null && root.right == null){
            leaves.add(root.val);
            return;
        }
        DFS(root.left,leaves);
        DFS(root.right,leaves);
    }
}
