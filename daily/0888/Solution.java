import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        /* 
            sumA - x + y = sumB + x - y
            y = (sumA - sumB) / 2 + x
        */

        int delta = (Arrays.stream(B).sum() - Arrays.stream(A).sum()) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int x : B) {
            setB.add(x);
        }
        
        int[] ans = new int[2];
        for (int x : A) {
            int y =  delta + x;
            if (setB.contains(y)) {
                ans[0] = x;
                ans[1] = y;
                return ans;
            }
        }

        return null;
    }
}