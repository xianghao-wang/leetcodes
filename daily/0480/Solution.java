import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    private class MedianHeap {
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;

        private int size;

        public MedianHeap() {
            small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            large = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        }

        public void add(int val) {
            small.add(val);
            large.add(small.poll());

            size ++;

            makeBalance();
        }

        public void remove(int val) {
            if (val <= small.peek()) {
                small.remove(val);
            } else {
                large.remove(val);
            }

            small.remove(val);
            large.remove(val);

            size --;

            makeBalance();
        }

        public double median() {
            return size % 2 == 0 ? small.peek() / 2.0 + large.peek() / 2.0 : small.peek();
        }

        private void makeBalance() {
            while (small.size() - large.size() > 1) {
                large.add(small.poll());
            }
            
            while (large.size() > small.size()) {
                small.add(large.poll());
            }
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        MedianHeap heap = new MedianHeap();

        for (int i = 0; i < k - 1; i ++) {
            heap.add(nums[i]);
        }

        for (int l = 0, r = k - 1; r < nums.length; l ++, r ++) {
            heap.add(nums[r]);
            ans[l] = heap.median();
            heap.remove(nums[l]);
        }

        return ans;
    }
}