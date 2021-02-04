class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();

        /* 用来模拟栈 */
        int top = 0;

        for (char c : S.toCharArray()) {
            if (c == ')') {
                top --;
            }
            
            if (top != 0) {
                ans.append(c);
            }

            if (c == '(') {
                top ++;
            }  
        }

        return ans.toString();
    }
}