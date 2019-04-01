package iluo.middleNode;

import iluo.util.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return head;
        ListNode quickHead = head;
        for(;quickHead != null && quickHead.next != null;){
            quickHead = quickHead.next;
            head = head.next;
            if(quickHead != null){
                quickHead = quickHead.next;
            }else{
                break;
            }
        }
        return head;
    }
}
