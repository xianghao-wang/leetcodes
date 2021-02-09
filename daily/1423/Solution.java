class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0;

        for (int i = 1; i <= k; i ++) {
            rSum += cardPoints[cardPoints.length - i];
        }

        int ans = rSum;
        for (int l = 1; l <= k; l ++) {
            lSum += cardPoints[l - 1];
            rSum -= cardPoints[cardPoints.length - k + l - 1];
            ans = Math.max(ans, lSum + rSum);
        }

        return ans;
    }
}