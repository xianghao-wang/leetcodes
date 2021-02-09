class Solution_2 {
    /**
     * 滑动窗口
    */
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0, len = s.length(), cost = 0, l = 0, r = 0;

        while(r < len) {
            cost += Math.abs(s.charAt(r) - t.charAt(r));

            while (maxCost < cost) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l ++;
            }

            ans = Math.max(ans, r - l + 1);
            r ++;
        }

        return ans;
    }
}