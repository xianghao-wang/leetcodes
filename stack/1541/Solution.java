class Solution {
    public int minInsertions(String s) {
        int top = 0, ans = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                top ++;
            } else {
                if (top == 0) {
                    if (i == s.length() - 1 || s.charAt(i + 1) != ')') {
                        ans += 2;
                    } else {
                        ans += 1;
                        i += 1;
                    }
                } else {
                    if (i == s.length() - 1 || s.charAt(i + 1) != ')') {
                        ans += 1;
                        top --;
                    } else {
                        i += 1;
                        top --;
                    }
                }
            }
        }

        while (top > 0) {
            top --;
            ans += 2;
        }

        return ans;
    }
}