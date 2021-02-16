import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] nextLargerNodes(ListNode head) {
        Map<Integer, Integer> nextBigs = new HashMap<>();
        Stack<int[]> stack = new Stack<>();
        ListNode p = head;
        int index = 0;

        while (p != null) {
            while (!stack.empty() && p.val > stack.peek()[0]) {
                int[] top = stack.pop();
                nextBigs.put(top[1], p.val);
            }

            int[] x = new int[2];
            x[0] = p.val;
            x[1] = index;
            stack.push(x);

            p = p.next;
            index ++;
        }

        int[] ans = new int[index];
        for (Map.Entry<Integer, Integer> entry : nextBigs.entrySet()) {
            ans[entry.getKey()] = entry.getValue();
        }

        return ans;
    }
}