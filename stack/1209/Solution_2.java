import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {
        int pAns = 0, p = 0;
        char[] ans = s.toCharArray();
        Stack<Integer> counts = new Stack<>();

        while (p < ans.length) {
            ans[pAns] = ans[p];

            if (pAns == 0 || ans[pAns] != ans[pAns - 1]) {
                counts.push(1);
            } else {
                int n = counts.pop() + 1;
                if (n == k) {
                    pAns -= k;
                } else {
                    counts.push(n);
                }
            }

            p ++;
            pAns ++;
        }

        return new String(ans, 0, pAns);
    }
}