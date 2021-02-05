package Inter0302;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mins;
 
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);

        if (mins.empty() || x < mins.peek()) {
            mins.push(x);
        } else {
            mins.push(mins.peek());
        }
    }
    
    public void pop() {
        mins.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */