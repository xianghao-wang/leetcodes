class Solution_2 {
    public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        int[] diffs = new int[A.length + 1];
        
        for (int l = 0, cnt = 0; l < A.length; l ++) {
            cnt += diffs[l];
            if ((A[l] + cnt) % 2 == 0) {
                if (l + K > A.length) {
                    return -1;
                }

                diffs[l + 1] += 1;
                diffs[l + K] -= 1;
                ans ++;
            }
        }

        return -1;
    }
}