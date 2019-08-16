package iluo.isPalindrome;

import iluo.util.ListNode;

/**
 * Created by Yang Xing Luo on 2019/8/7.
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode midNode = head;
        ListNode twoStep = head;
        int count = 1;
        for(;twoStep != null;){
            twoStep = twoStep.next;
            count++;
            if(twoStep != null){
                count++;
                twoStep = twoStep.next;
                midNode = midNode.next;
            }
        }
        if(count % 2 == 0) midNode = midNode.next;
        ListNode dummyHead = new ListNode(0);
        while(midNode != null){
            ListNode temp = midNode;
            midNode = midNode.next;
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }
        midNode = dummyHead.next;
        for(;midNode != null;){
            if(head.val != midNode.val) return false;
            head = head.next;
            midNode = midNode.next;
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int[] a = {1,2,3,2,1,1,2,3,1};
        for(int i = 0;i < a.length;i++){
            ListNode node = new ListNode(a[i]);
            temp.next = node;
            temp = temp.next;
        }
        boolean r = solution.isPalindrome(head);
        System.out.println(r);
    }
}
