class Solution {
    public boolean check(int[] nums) {
        if (nums.length == 1 || nums.length == 2) {
            return true;
        }

        for (int x = 0; x < nums.length; x ++) {
            boolean flag = true;
            for (int i = 1; i < nums.length; i ++) {
                int pre = (x + i - 1 + nums.length) % nums.length;
                int cur = (x + i) % nums.length;
                if (nums[pre] > nums[cur]) {
                    flag = false;
                    break;
                }        
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }
}