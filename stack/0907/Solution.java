import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nextSmallOrEqual = new int[arr.length];
        int[] previousSmall = new int[arr.length];
        Stack<Integer> stack = new Stack<>(); // 单调递增栈
        for (int i = 0; i < nextSmallOrEqual.length; i ++) nextSmallOrEqual[i] = arr.length;
        for (int i = 0; i < arr.length; i ++) {
            while (!stack.empty() && arr[i] <= arr[stack.peek()]) {
                nextSmallOrEqual[stack.pop()] = i;
            }
            previousSmall[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }

        long MOD = 1000000007;
        int ans = 0;
        for (int i = 0; i < arr.length; i ++) {
            long l = i - previousSmall[i] - 1;
            long r = nextSmallOrEqual[i] - i - 1;
            ans = (int) ((ans % MOD + ((l + 1) * (r + 1) * arr[i]) % MOD) % MOD);
        }

        return ans;
    }

}