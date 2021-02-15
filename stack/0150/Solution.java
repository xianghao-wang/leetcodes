import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> vals = new Stack<>();

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                vals.push(Integer.parseInt(token));
            } else {
                int b = vals.pop();
                int a = vals.pop();
                vals.push(operate(a, b, token.charAt(0)));
            }
        }

        return vals.peek();
    }

    private int operate(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: return 0;
        }
    }
}