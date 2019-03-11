package iluo.MyQueue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int result = stack1.pop();
        while (stack2.size() != 0){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        while (stack1.size() != 0){
            stack2.push(stack1.pop());
        }
        int result = stack2.peek();
        while (stack2.size() != 0){
            stack1.push(stack2.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.size() == 0) return true;
        else return false;
    }
}
