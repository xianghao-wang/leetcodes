import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);   
            if (c != 'c') {
                stack.push(c);
            } else if (stack.size() >= 2) {
                char b = stack.pop();
                char a = stack.pop();
                if (a == 'a' && b == 'b') {
                    continue;
                } else {
                    stack.push(a);
                    stack.push(b);
                    stack.push('c');
                }
            }
        }

        return stack.empty();
    }
}