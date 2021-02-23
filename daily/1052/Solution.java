class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0, n = customers.length;

        for (int i = 0; i < n; i ++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
            }
        }

        for (int i = 0; i < X - 1; i ++) {
            if (grumpy[i] == 1) {
                ans += customers[i];
            }
        }

        int t = ans;
        for (int l = 0, r = X - 1; r < n; l ++, r ++) {
            if (grumpy[r] == 1) {
                t += customers[r];
            }
            
            ans = Math.max(t, ans);

            if (grumpy[l] == 1) {
                t -= customers[l];
            }
        } 

        return ans;
    }
}