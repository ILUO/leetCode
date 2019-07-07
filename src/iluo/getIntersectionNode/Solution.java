package iluo.getIntersectionNode;

import iluo.util.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA,B = headB;
        int countA = 0,countB = 0;
        for(;headA != null;headA = headA.next) countA++;
        for(;headB != null;headB = headB.next) countB++;
        int dif = 0;
        if(countA > countB){
            for(;dif < countA - countB;dif++){
                A = A.next;
            }
        }else{
            for(;dif < countB - countA;dif++){
                B = B.next;
            }
        }
        while(A != null && B != null){
            if(A == B) return A;
            else{
                A = A.next;
                B = B.next;
            }
        }
        return null;
    }
}
