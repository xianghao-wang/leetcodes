class Solution {
    public int longestOnes(int[] A, int K) {
        int l = 1, r = A.length, ans = 0;

        /* 前缀和统计1的个数 */
        int[] prefix = new int[A.length];
        prefix[0] = A[0];
        for (int i = 1; i < A.length; i ++) {
            prefix[i] = prefix[i - 1] + A[i];
        }

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(prefix, K, mid)) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int[] prefix, int K, int len) {
        for (int l = 0; l <= prefix.length - len; l ++) {
            int n0 = len - prefix[l + len - 1] + (l == 0 ? 0 : prefix[l - 1]); // the number of 0s
            if (K >= n0) {
                return true;
            }
        }
        return false;
    }
}