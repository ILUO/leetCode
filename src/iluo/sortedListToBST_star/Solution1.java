package iluo.sortedListToBST_star;

import iluo.util.ListNode;
import iluo.util.TreeNode;

public class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        // ArrayList<Integer> num = new ArrayList<>();
        // for(;head != null;head = head.next){
        //     num.add(head.val);
        // }
        TreeNode result = null;
        return toBST(result,head,null);
    }

    private TreeNode toBST(TreeNode root,ListNode start,ListNode end){
        if(start == end) return root;
        ListNode mid = getMid(start,end);
        TreeNode node = new TreeNode(mid.val);
        root = node;
        root.left = toBST(root.left,start,mid);
        root.right = toBST(root.right,mid.next,end);
        return root;
    }

    private ListNode getMid(ListNode head,ListNode end){
        ListNode quickHead = head;
        for(;quickHead != end;){
            quickHead = quickHead.next;
            if(quickHead != end){
                quickHead = quickHead.next;
                head = head.next;
            }
        }
        return head;
    }
}
