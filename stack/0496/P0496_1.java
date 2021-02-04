class Solution_1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i ++) {
            int x = -1; /* 下一个更大的元素 */

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