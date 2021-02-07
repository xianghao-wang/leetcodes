package P2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    /**
     * 贪心算法，尽可能取较大的两堆
    */
    public int maximumScore(int a, int b, int c) {
        int ans = 0;

        /* 大根堆每次可以取出最大的两堆石子 */
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        q.add(a);
        q.add(b);
        q.add(c);

        while (true) {
            int m = q.poll(), n = q.poll();

            if (m == 0 || n == 0) {
                break;
            }

            q.add(m - 1);
            q.add(n - 1);
            ans += 1;
        }

        return ans;
    }
}