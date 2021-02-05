class Solution {
    /**
     * 暴力法，遍历nums1[i]对应nums2位置后的每一个元素
     * 时间：O(nums1.length * nums2.length)
     * 空间：O(N)
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i ++) {
            int x = -1; /* 下一个更大的元素 */

            /* 找到nums[i]在nums2里的对应位置 */
            int j = 0;
            while (j != nums2.length && nums1[i] != nums2[j]) {
                j ++;
            }

            for (int k = j; k < nums2.length; k ++) {
                if (nums2[k] > nums1[i]) {
                    x = nums2[k];
                    break;
                }
            }

            ans[i] = x;
        }
        
        return ans;
    }
}