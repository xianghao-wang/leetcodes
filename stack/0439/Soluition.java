import java.util.Stack;

class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();

        int i = expression.length() - 1;

        while (i >= 0) {
            char c = expression.charAt(i);
            if (c == '?') {
                if (expression.charAt(i - 1) == 'T') {
                    char top = stack.pop();
                    stack.pop();
                    stack.push(top);
                } else {
                    stack.pop();
                }
                i -= 1;
            } else if (c != ':') {
                stack.push(c);
            }

            i -= 1;
        }

        return String.valueOf(stack.peek());
    }
}