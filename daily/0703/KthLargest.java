import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    private Queue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        /* 小根堆，维护最大的k个数 */
        heap = new PriorityQueue<>();

        for (int x : nums) {
            heap.add(x);
        }
    }

    public int add(int val) {
        heap.add(val);

        while (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */