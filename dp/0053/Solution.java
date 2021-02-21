class Solution {
    public int maxSubArray(int[] nums) {
        /*
            dp[i]: 以nums[i]为结尾的和最大的子序
            dp[0] = nums[0]
            dp[i] = max(dp[i-1], 0) + 1
        */

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];

        for (int i = 1; i < n; i ++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}