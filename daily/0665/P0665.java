class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1 || nums.length == 2) {
            return true;
        }

        boolean changed = false;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] > nums[i + 1]) {
                if (changed) {
                    return false;
                }

                changed = true;
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }
}