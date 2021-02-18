import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int head = 0;

        for (int i = 0; i < pushed.length; i ++) {
            stack.push(pushed[i]);
            while (!stack.empty() && stack.peek() == popped[head]) {
                head ++;
                stack.pop();
            }
        }

        return stack.empty();
    }
}