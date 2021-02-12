import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> small;
    Queue<Integer> large;
    int size = 0;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());

        if (small.size() < large.size()) {
            small.add(large.poll());
        }

        size ++;
    }
    
    public double findMedian() {
        return size % 2 == 1 ? small.peek() : (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */