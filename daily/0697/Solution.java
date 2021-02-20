import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int x : nums) {
            frequencies.put(x, frequencies.getOrDefault(x, 0) + 1);
            degree = Math.max(frequencies.get(x), degree);
        }

        Map<Integer, int[]> startAndEnd = new HashMap<>();
        for (Map.Entry<Integer, Integer> x : frequencies.entrySet()) {
            if (degree == x.getValue()) {
                startAndEnd.put(x.getKey(), new int[2]);
                startAndEnd.get(x.getKey())[0] = -1;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            if (startAndEnd.containsKey(nums[i])) {
                if (startAndEnd.get(nums[i])[0] == -1) {
                    startAndEnd.get(nums[i])[0] = i;
                }
                startAndEnd.get(nums[i])[1] = i;
            }
        }

        int ans = nums.length;
        for (Map.Entry<Integer, int[]> entry : startAndEnd.entrySet()) {
            ans = Math.min(ans, entry.getValue()[1] - entry.getValue()[0] + 1);
        } 

        return ans;
    }
}