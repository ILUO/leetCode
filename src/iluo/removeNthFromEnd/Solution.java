package iluo.removeNthFromEnd;

import iluo.util.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode result = head;
        ListNode secondNode = head;
        for(int i=0;i < n;i++){
            secondNode = secondNode.next;
        }
        for(;secondNode != null && secondNode.next != null;){
            head = head.next;
            secondNode = secondNode.next;
        }
        if(secondNode == null) return head.next;
        head.next = head.next.next;
        return result;
    }
}
