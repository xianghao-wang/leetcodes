class Solution_1 {
    /**
     * 动态规划
    */
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        int[] dp = new int[arr.length];
        dp[0] = 1;
        dp[1] = arr[0] != arr[1] ? 2 : 1;

        for (int i = 2; i < arr.length; i ++) { 
            if (arr[i] == arr[i - 1]) {
                dp[i] = 1;
            } else {
                int a = arr[i] - arr[i - 1];
                int b = arr[i - 1] - arr[i - 2];

                if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 2;
                }
            }
        }

        int ans = 1;
        for (int i = 0; i < dp.length; i ++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}