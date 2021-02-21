class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, ans = nums[0];

        int[] dp1 = new int[n]; // 最大
        int[] dp2 = new int[n]; // 最小
        dp1[0] = nums[0];
        dp2[0] = nums[0];

        for (int i = 1; i < n; i ++) {
            dp1[i] = Math.max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]);
            dp1[i] = Math.max(dp1[i - 1], nums[i]);
            dp2[i] = Math.max(dp2[i - 1] * nums[i], dp1[i - 1] * nums[i]);
            dp2[i] = Math.max(dp2[i - 1], nums[i]);
            ans = Math.max(dp1[i], ans);
        }

        return ans;
    }
}