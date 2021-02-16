import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String S) {
        int res = 0, depth = 0;

        for (int i = 0; i < S.length(); i ++) {
            char c = S.charAt(i);

            if (c == '(') {
                depth += 1;
            } else {
                depth -= 1;
            }

            if (c == ')' && S.charAt(i - 1) == '(') {
                res += 1 << depth;
            }
        }

        return res;
    }
}