import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        Queue<Integer> small = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        Queue<Integer> large = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);

        for (int l = 0, r = 0; r < nums.length; r ++) {
            while (!small.isEmpty() && (small.peek() < l || Math.abs(nums[small.peek()] - nums[r]) > limit)) {
                l = Math.max(l, small.poll() + 1);
            }

            while (!large.isEmpty() && (large.peek() < l || Math.abs(nums[large.peek()] - nums[r]) > limit)) {
                l = Math.max(l, large.poll() + 1);
            }

            small.add(r);
            large.add(r);

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}