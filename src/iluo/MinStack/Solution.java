package iluo.MinStack;

import java.util.ArrayList;

public class Solution {
    class MinStack {
        private ArrayList<Integer> arrayList;
        private ArrayList<Integer> minArrayList;

        /** initialize your data structure here. */
        public MinStack() {
            arrayList = new ArrayList<Integer>();
            minArrayList = new ArrayList<Integer>();
        }

        public void push(int x) {
            arrayList.add(x);
            if(minArrayList.size() == 0 || x < minArrayList.get(minArrayList.size() - 1)){
                minArrayList.add(x);
            }else{
                minArrayList.add(minArrayList.get(minArrayList.size() - 1));
            }
        }

        public void pop() {
            if(arrayList.size() > 0){
                arrayList.remove(arrayList.size() - 1);
                minArrayList.remove(minArrayList.size() - 1);
            }
        }

        public int top() {
            return arrayList.get(arrayList.size() - 1);
        }

        public int getMin() {
            return minArrayList.get(minArrayList.size() - 1);
        }
    }
}
