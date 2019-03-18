package iluo.sortList_star;

import iluo.util.ListNode;

import java.util.ArrayList;

public class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> num = new ArrayList<>();
        ListNode location = new ListNode(0);
        location.next = head;
        head = location.next;
        for(;head != null;head = head.next){
            num.add(head.val);
        }
        quicksort(num,0,num.size()-1);
        head = location.next;
        int count = 0;
        for(;head != null;head = head.next){
            head.val = num.get(count);
            count++;
        }
        return location.next;
    }
    private void quicksort(ArrayList<Integer> num,int low,int high){
        if(low >= high) return;
        int i = low;
        int j = high+1;
        int comp = num.get(low);
        while(true){
            while (num.get(++i) <= comp) if(i == high) break;
            while(num.get(--j) >= comp) if(j == low) break;
            if(i >= j){
                break;
            }
            int temp = num.get(i);
            num.set(i,num.get(j));
            num.set(j,temp);
        }
        num.set(low,num.get(j));
        num.set(j,comp);
        quicksort(num,low,j-1);
        quicksort(num,j+1,high);
    }
}
