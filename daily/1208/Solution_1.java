class Solution_1 {
    /**
     * 二分答案+前缀和
    */
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int len = s.length();
        
        /* 前缀和存储[0....i]字符串转换的开销 */
        int costs[] = new int[len];
        for (int i = 0; i < len; i ++) {
            int d = Math.abs(s.charAt(i) - t.charAt(i));
            costs[i] = i == 0 ? d : costs[i - 1] + d;
        }

        int l = 0, r = s.length();
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(s, t, maxCost, costs, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public boolean check(String s, String t, int maxCost, int[] costs, int ans) {
        /* 公共字符串长度为0 */
        if (ans == 0) {
            return true;
        }

        int len = s.length();
        for (int l = 0; l <= len - ans; l ++) {
           int cost = costs[l + ans - 1] - (l == 0 ? 0 : costs[l - 1]);
           if (cost <= maxCost) {
               return true;
           }
        }

        return false;
    }
}