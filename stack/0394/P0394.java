import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> repetitions = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();
        strs.push(new StringBuilder());
        
        int p = 0;
        while (p < s.length()) {
            char c = s.charAt(p);

            if (Character.isLetter(c)) {
                /* 字母 */
                while (p < s.length() && Character.isLetter(s.charAt(p))) {
                    strs.peek().append(s.charAt(p));
                    p ++;
                }
            } else if (Character.isDigit(c)) {
                int k = 0;
                while (p < s.length() && Character.isDigit(s.charAt(p))) {
                    k = k * 10 + s.charAt(p) - '0';
                    p ++;
                }
                repetitions.push(k);
            } else if (c == ']') {
                int multi = repetitions.pop();
                StringBuilder top = strs.pop();
                
                while (multi > 0) {
                    strs.peek().append(top);
                    multi --;
                }

                p ++;
            } else {
                strs.push(new StringBuilder());
                p ++;
            }

        }

        return strs.peek().toString();
    }

    // public static void main(String[] args) {
    //     String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
    //     System.out.println(new Solution().decodeString(s));
    // }
}