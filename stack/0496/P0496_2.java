import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        /* 单调递减栈 */
        Stack<Integer> s = new Stack<>();

        /* nums1中各元素的位置 */
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums1.length; i ++) {
            indices.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i ++) {
            while (!s.empty() && nums2[i] > s.peek()) {
                int top = s.pop();
                Integer index = indices.get(top);
                if (index != null) {
                    ans[index] = nums2[i];
                }
            }
            s.push(nums2[i]);
        }

        for (int i = 0; i < ans.length; i ++) {
            if (ans[i] == 0) {
                ans[i] = -1;
            }
        }

        return ans;
    }
}