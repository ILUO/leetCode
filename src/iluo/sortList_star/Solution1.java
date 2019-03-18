package iluo.sortList_star;

import iluo.util.ListNode;

/**
 * Created by Yang Xing Luo on 2019/3/18.
 */
public class Solution1 {
    public ListNode sortList(ListNode head) {
        ListNode tail = head;
        for(;tail.next != null;tail = tail.next);
        merSort(head,tail);
        return head;
    }

    private ListNode getMidNode(ListNode head,ListNode quickHead,ListNode tail){
        for(;quickHead != tail;){
            quickHead = quickHead.next;
            if(quickHead != tail){
                quickHead = quickHead.next;
                head = head.next;
            }
        }
        return head;
    }



    private void merSort(ListNode head,ListNode tail){
        ListNode midNode = getMidNode(head,head,tail);
        if(head == midNode){
            if(head.next == tail){
                if(head.val > midNode.val){
                    int temp = midNode.val;
                    midNode.val = head.val;
                    head.val = temp;
                }
            }
            return;
        }else{
            merSort(head,midNode);
            merSort(midNode.next,tail);
            mergeList(head,midNode.next);
        }
    }


    private ListNode mergeList(ListNode head1,ListNode head2){
        ListNode toolNode = new ListNode(0);
        ListNode head = new ListNode(0);
        if(head1.val < head2.val){
            head = head1;
            head1 = head1.next;
        }else{
            head = head2;
            head2 = head2.next;
        }
        toolNode.next = head;
        for(;head1 != null && head2 != null;head = head.next){
            if(head1.val < head2.val){
                head.next = head1;
                head1 = head1.next;
            }else{
                head.next = head2;
                head2 = head2.next;
            }
        }
        if(head1 == null){
            head.next = head2;
        }else{
            head.next = head1;
        }
        return toolNode.next;
    }

    public static void main(String[] args){
        Solution1 solution = new Solution1();
        int[] a = {4,2,1,3};
        ListNode toolNode = new ListNode(0);
        ListNode tempNode = new ListNode(0);
        toolNode.next = tempNode;
        for(int i = 0;i < a.length;i++){
            ListNode node = new ListNode(a[i]);
            tempNode.next = node;
            tempNode = tempNode.next;
        }
        solution.sortList(toolNode.next);
        System.out.println(toolNode.next.val);
    }
}
