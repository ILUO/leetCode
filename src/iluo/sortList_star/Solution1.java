package iluo.sortList_star;

import iluo.util.ListNode;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2019/3/18.
 */
public class Solution1 {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        head = merSort(head);
        return head;
    }

    private ListNode getMidNode(ListNode head,ListNode quickHead){
        for(;quickHead != null;){
            quickHead = quickHead.next;
            if(quickHead != null){
                quickHead = quickHead.next;
                if(quickHead != null){
                    head = head.next;
                }

            }
        }
        return head;
    }

    private ListNode merSort(ListNode head){
        if(head.next == null) return head;
        ListNode midNode = getMidNode(head,head);
        ListNode newStart = midNode.next;
        midNode.next = null;
        head = merSort(head);
        newStart = merSort(newStart);
        return mergeList(head,newStart);
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
        ListNode tempNode = new ListNode(4);
        toolNode.next = tempNode;
        for(int i = 1;i < a.length;i++){
            ListNode node = new ListNode(a[i]);
            tempNode.next = node;
            tempNode = tempNode.next;
        }
        ListNode result = solution.sortList(toolNode.next);
        System.out.println(result.val);
    }
}
