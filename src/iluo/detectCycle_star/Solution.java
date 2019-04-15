package iluo.detectCycle_star;

import iluo.util.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode first = head;
        ListNode quickHead = head;
        for(;quickHead != null && head != null;){
            head = head.next;
            if(head == null) return null;
            quickHead = quickHead.next;
            if(quickHead != null) quickHead = quickHead.next;
            else return null;
            if(head == quickHead){
                break;
            }
        }
        if(quickHead == null) return null;
        for(head = first;;head=head.next,quickHead = quickHead.next){
            if(head == quickHead){
                first = head;
                break;
            }
        }
        return first;
    }}
