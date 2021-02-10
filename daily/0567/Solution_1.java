class Solution_1 {
    /**
     * 滑动窗口 (窗口长度固定)
    */
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int[] candidates = new int[128];
        int[] used = new int[128];

        for (int i = 0; i < s1.length(); i ++) {
            candidates[s1.charAt(i)] ++;
        }

        int pLen = s1.length();
        for (int i = 0; i < pLen - 1; i ++) {
            used[s2.charAt(i)] ++;
        }

        int l = 0, r = pLen - 1;
        while (r < s2.length()) {
            used[s2.charAt(r)] ++;

            if (check(candidates, used)) {
                return true;
            }

            used[s2.charAt(l)] --;
            l ++;
            r ++;
        }

        return false;
    }

    public boolean check(int[] candidates, int[] used) {
        for (int i = 0; i < candidates.length; i ++) {
            if (candidates[i] != used[i]) {
                return false;
            }
        }

        return true;
    }
}