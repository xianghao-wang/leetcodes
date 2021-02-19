class Solution {
    /**
     * 滑动窗口
    */

    public int longestOnes(int[] A, int K) {
        int ans = 0, cnt = 0;

        for (int l = 0, r = 0; r < A.length; r ++) {
            cnt += A[r];

            while ((r - l + 1 - cnt) > K) {
                cnt -= A[l];
                l ++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}