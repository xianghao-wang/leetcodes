import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> vals = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i ++;
                continue;
            }

            if (Character.isDigit(c)) {
                int x = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    x = x * 10 + s.charAt(i) - '0';
                    i ++;
                }
                vals.push(x);
            } else {
                if (c == '+' || c == '-') {
                    if (!operators.empty()) {
                        int b = vals.pop();
                        int a = vals.pop();
                        vals.push(operate(a, b, operators.pop()));
                    }
                    operators.push(c);
                    i ++;
                } else {
                    while (!Character.isDigit(s.charAt(i))) i ++;
                    int x = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        x = x * 10 + s.charAt(i) - '0';
                        i ++;
                    }
                    vals.push(operate(vals.pop(), x, c));
                }
            }
        }

        while (!operators.empty()) {
            int b = vals.pop();
            int a = vals.pop();
            vals.push(operate(a, b, operators.pop()));
        }

        return vals.pop();
    }

    private int operate(int a, int b, int operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }
}