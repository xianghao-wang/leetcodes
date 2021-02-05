import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new LinkedList<>();
        int count = 1;

        for (int i = 0; i <= target[target.length - 1]; i ++) {
            if (i == count) {
                ans.add("Push");
                count ++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }

        return ans;
    }
}