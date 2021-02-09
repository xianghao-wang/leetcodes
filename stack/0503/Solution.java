import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        /* 两个相同的nums拼接在一起用来模拟循环数组 */
        int[] expandedNums = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i ++) {
            expandedNums[i] = nums[i];
            expandedNums[i + nums.length] = nums[i];
        }

        /* 创建ans存储答案，并全部填充为-1 */
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        /* 单调递减栈 */
        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < expandedNums.length; i ++) {
            while (!indices.empty() && expandedNums[i] > expandedNums[indices.peek()]) {
                int top = indices.pop();
                if (top < nums.length) {
                    ans[top] = expandedNums[i];
                }
            }
            indices.push(i);
        }

        return ans;
    }
}