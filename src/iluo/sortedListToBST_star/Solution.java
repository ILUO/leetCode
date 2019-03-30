package iluo.sortedListToBST_star;

import iluo.util.ListNode;
import iluo.util.TreeNode;
import java.util.ArrayList;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> num = new ArrayList<>();
        for(;head != null;head = head.next){
            num.add(head.val);
        }
        TreeNode result = null;
        return toBST(result,0,num.size()-1,num);
    }

    private TreeNode toBST(TreeNode root,int start,int end,ArrayList<Integer> num){
        if(start > end) return root;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(num.get(mid));
        root = node;
        root.left = toBST(root.left,start,mid - 1,num);
        root.right = toBST(root.right,mid + 1,end,num);
        return root;
    }

    public static void main(String[] args){
        int[] a = {-10, -3, 0, 5, 9};
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i = 0;i < a.length;i++){
            ar.add(a[i]);
        }
        Solution solution = new Solution();
        TreeNode node = null;
        node = solution.toBST(node,0,a.length-1,ar);
        System.out.println("123");
    }
}
