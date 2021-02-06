import java.util.Stack;

class Solution {
    /**
     * 单调递减栈
    */
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < T.length; i ++) {
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                int top = stack.pop();
                ans[top] = i - top;
            }

            stack.push(i);
            
        }

        return ans;
    }
}