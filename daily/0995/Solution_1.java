class Solution_1 {
    public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        for (int l = 0; l <= A.length - K; l ++) {
            if (A[l] == 0) {
                int r = l + K - 1;
                for (int i = l; i <= r; i ++) {
                    A[i] ^= 1;
                }
                ans ++;
            }
        }

        for (int i = 0; i < A.length; i ++) {
            if (A[i] == 0) {
                return -1;
            }
        }

        return ans;
    }
}