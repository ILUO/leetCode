package iluo.addTwoNumbersII;

import iluo.util.ListNode;

/**
 * Created by Yang Xing Luo on 2019/2/3.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        for(;l1 != null;l1 = l1.next){
            ListNode temp = new ListNode(l1.val);
            temp.next = head1.next;
            head1.next = temp;
        }
        for(;l2 != null;l2 = l2.next){
            ListNode temp = new ListNode(l2.val);
            temp.next = head2.next;
            head2.next = temp;
        }
        head1 = head1.next;
        head2 = head2.next;
        ListNode result = new ListNode(0);
        int carry = 0;
        while(head1 != null || head2!= null || carry != 0){
            int num1 = 0;
            int num2 = 0;
            if(head1 != null){
                num1 = head1.val;
            }
            if(head2 != null){
                num2 = head2.val;
            }
            int sum = num1 + num2 + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = result.next;
            result.next = temp;
            if(head1 != null){
                head1 = head1.next;
            }
            if(head2 != null){
                head2 = head2.next;
            }
        }
        return result.next;
    }

    private int getPowerOfTen(int i){
        if(i == 0){
            return 1;
        }else{
            return 10*getPowerOfTen(i - 1);
        }
    }
}
