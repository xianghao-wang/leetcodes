package P3;

class Solution {
    /* 暴力法 */
    public String largestMerge(String word1, String word2) {
        int p = 0, q = 0;
        String merge = "";

        while (p < word1.length() || q < word2.length()) {
            String sub1 = word1.substring(p), sub2 = word2.substring(q);
            if (p == word1.length()) {
                merge += sub2;
                break;
            }

            if (q == word2.length()) {
                merge += sub1;
                break;
            }

            int c = sub1.compareTo(sub2);
            if (c < 0) {
                merge += sub2.charAt(0);
                q ++;
            } else {
                merge += sub1.charAt(0);
                p ++;
            }
        }

        return merge;
    }
}