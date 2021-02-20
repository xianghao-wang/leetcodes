import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution_1 {
    public String removeDuplicates(String s, int k) {
        Deque<Character> stack = new LinkedList<>();
        Stack<Integer> numStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c != stack.getLast()) {
                numStack.push(1);
            } else {
                numStack.push(numStack.pop() + 1);
            }
            stack.addLast(c);

            if (numStack.peek() == k) {
                numStack.pop();
                for (int j = 0; j < k; j ++) {
                    stack.pollLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}