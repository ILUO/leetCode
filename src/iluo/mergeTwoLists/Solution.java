package iluo.mergeTwoLists;

import iluo.util.ListNode;

/**
 * Created by Yang Xing Luo on 2019/3/24.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode result = head;
        for(;l1 != null && l2 != null;){
            if(l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }else{
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) head.next = l1;
        if(l2 != null) head.next = l2;
        return result.next;
    }
}
