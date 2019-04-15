package iluo.hasCycle;

import iluo.util.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode quickHead = head;
        for(;quickHead != null && head != null;){
            head = head.next;
            if(head == null) return false;
            quickHead = quickHead.next;
            if(quickHead != null) quickHead = quickHead.next;
            else return false;
            if(head == quickHead) return true;
        }
        return false;
    }
}
