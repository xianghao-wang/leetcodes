class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
            dp[i], 以i位置为结尾的最长上升子序列
            dp[0] = 1
            dp[i] = max{ dp[j] + 1 } (j < i, nums[i] > nums[j])
        */

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;

        for (int i = 1; i < nums.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}