class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        for (int l = 0, r = 0; r < nums.length; r ++) {
            if (nums[r] == 0) {
                l = r + 1;
                continue;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}