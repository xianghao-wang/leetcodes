import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        stack.push("");

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push("");
            } else if (c == ')') {
                String newTop = reversed(stack.pop());
                newTop = stack.pop() + newTop;
                stack.push(newTop);
            } else {
                stack.push(stack.pop() + c);
            }
        }

        return stack.pop();
    }

    private String reversed(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i --) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}