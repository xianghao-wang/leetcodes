class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;
        int distincts = 0;
        int[] count = new int[128];

        int l = 0;
        for (int r = 0; r < s.length(); r ++) {
            if (count[s.charAt(r) - 'A'] == 0) {
                distincts ++;
            }
            count[s.charAt(r) - 'A'] ++;

            while (distincts > 2) {
                count[s.charAt(l) - 'A'] --;
                if (count[s.charAt(l) - 'A'] == 0) {
                    distincts --;
                }
                l ++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}