class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ans = 0;
        int[] count = new int[128];
        int distincts = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r ++) {
            char c = s.charAt(r);
            if (count[c] == 0) {
                distincts ++;
            }

            count[c] ++;

            while (distincts > k) {
                count[s.charAt(l)] --;
                if (count[s.charAt(l)] == 0) {
                    distincts --;
                }
                l ++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}