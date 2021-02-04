import java.util.Stack;

class MyQueue_1 {
    Stack<Integer> stack;
    Stack<Integer> exchange;

    /** Initialize your data structure here. */
    public MyQueue_1() {
        stack = new Stack<>();
        exchange = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty()) {
            exchange.push(stack.pop());
        }

        stack.push(x);

        while (!exchange.isEmpty()) {
            stack.push(exchange.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() { 
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }   
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */