import java.util.HashSet;
import java.util.Set;

class Solution_2 {
    public String minRemoveToMakeValid(String s) {
        /* 首先正序遍历，移除右括号 */
        StringBuilder sb = new StringBuilder();
        int top = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') top ++;
            else if (s.charAt(i) == ')') {
                if (top == 0) continue;
                top --;
            }
            sb.append(s.charAt(i));
        }

        if (top == 0) {
            return sb.toString();
        }

        /* 然后逆序遍历剩余的字符串，移除左括号 */
        top = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i --) {
            if (sb.charAt(i) == ')') top ++;
            else if (sb.charAt(i) == '(') {
                if (top == 0) continue;
                top --;
            }
            ans.append(sb.charAt(i));
        }

        return ans.reverse().toString();
    }
}
