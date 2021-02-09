import java.util.HashSet;
import java.util.Set;

class Solution_1 {
    /**
     * 暴力法，遍历每一个子数组
     * 时间: O(N^2)
     * 空间: O(N)
     * 该方法会超出时间限制
    */
    public int subarraysWithKDistinct(int[] A, int K) {
        int ans = 0;
        for (int l = 0; l < A.length; l ++) {
            Set<Integer> visited = new HashSet<>();
            for (int r = l; r < A.length; r ++) {
                visited.add(A[r]);

                if (visited.size() == K) {
                    ans ++;
                }

                /* 子数组不相同的元素数量肯定不够 K */
                if (visited.size() + A.length - r < K) {
                    break;
                }


                /* 子数组不相同的元素数量肯定大于 K */
                if (visited.size() > K) {
                    break;
                }
            }
        }

        return ans;
    }
}