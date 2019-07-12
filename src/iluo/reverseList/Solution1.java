package iluo.reverseList;

import iluo.util.ListNode;

/**
 * Created by Yang Xing Luo on 2019/7/12.
 */
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        for(;head != null;){
            ListNode temp = dummyHead.next;
            dummyHead.next = head;
            head = head.next;
            dummyHead.next.next = temp;
        }
        return dummyHead.next;
    }
}
