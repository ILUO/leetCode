package iluo.reverseList;

import iluo.util.ListNode;

/**
 * Created by Yang Xing Luo on 2019/7/12.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        for(;head != null;head = head.next){
            reverseCore(head,dummyHead);
        }
        return dummyHead.next;
    }

    private ListNode reverseCore(ListNode head,ListNode dummyHead){
        if(head.next == null){
            dummyHead.next = head;
            return head;
        }
        ListNode next = reverseCore(head.next,dummyHead);
        next.next = head;
        head.next = null;
        return head;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(1);
        dummy.next = head;
        for(int i = 1;i < a.length;i++){
            ListNode next = new ListNode(a[i]);
            head.next = next;
            head = next;
        }
        Solution solution = new Solution();
        solution.reverseList(dummy.next);
    }


}
