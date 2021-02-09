import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_2 {
    /**
     * 滑动窗口
     * 时间: O(N)
     * 空间: O(1)
    */

    public int subarraysWithKDistinct(int[] A, int K) {
        return numbersOfSubarraysWithMostKDistinctElements(A, K) - numbersOfSubarraysWithMostKDistinctElements(A, K - 1);
    }

    public int numbersOfSubarraysWithMostKDistinctElements(int[] A, int K) {
        int ret = 0;
        int distincts = 0;
        int[] count = new int[Arrays.stream(A).max().getAsInt() + 1];

        for (int l = 0, r = 0; r < A.length; r ++) {
            if (count[A[r]] == 0) {
                distincts ++;
            }
            count[A[r]] ++;

            while (distincts > K) {
                count[A[l]] --;
                if (count[A[l]] == 0) {
                    distincts --;
                }
                l ++;
            }

            ret += r - l;
        }

        return ret;
    }
}
