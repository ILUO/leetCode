package iluo.mergeKLists_star;

import iluo.util.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return helper(lists,0,lists.length - 1);
    }

    private ListNode helper(ListNode[] lists,int left,int right){
        if(left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode l = helper(lists,left,mid);
        ListNode r = helper(lists,mid+1,right);
        return merge(l,r);
    }

    private ListNode merge(ListNode l,ListNode r){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l != null && r != null){
            if(l.val < r.val){
                temp.next = l;
                l = l.next;
            }else{
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }
        if(l != null){
            temp.next = l;
        }
        if(r != null){
            temp.next = r;
        }
        return head.next;
    }
}
