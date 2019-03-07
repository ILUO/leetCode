package iluo.deleteDuplicates;

import iluo.util.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        for(;head != null && head.next != null;){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return first.next;
    }
}
