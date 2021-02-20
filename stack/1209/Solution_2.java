import java.util.Stack;

class Solution_2 {
    public String removeDuplicates(String s, int k) {
        int pAns = 0, p = 0;
        char[] ans = s.toCharArray();
        Stack<Integer> counts = new Stack<>();

        while (p < ans.length) {
            ans[pAns] = ans[p];

            if (j == 0 || ans[j] != ans[j - 1]) {
                counts.push(1);
            } else {
                int n = counts.pop() + 1;
                if (n == k) {
                    j -= k;
                }
            }

            p ++;
            pAns ++;
        }
    }
}