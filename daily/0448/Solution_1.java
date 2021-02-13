import java.util.LinkedList;
import java.util.List;

class Solution_1 {
    /**
     * 使用一个数组统计哪个数出现
     * 时间: O(N)
     * 空间: O(N)
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        boolean[] visited = new boolean[nums.length + 1];

        for (int x : nums) {
            visited[x] = true;
        }

        for (int i = 1; i < visited.length; i ++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}