import java.util.List;
import java.util.Arrays;

class Solution {
    /**
     * 模拟法，当前元素等于上方元素和左上方元素之和
    */
    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex + 1];
        ans[0] = 1;

        for (int i = 1; i <= rowIndex; i ++) {
            for (int j = i; j >= 1; j --) {
                ans[j] = ans[j - 1] + (ans[j] == null ? 0 : ans[j]);
            }
        }

        return (List<Integer>) Arrays.asList(ans);
    }
}