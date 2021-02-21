import java.util.Comparator;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        /*
            dp[i]: 代表i位置信封为最外层的俄罗斯套娃内信封最大数量
            dp[i] = max{ dp[j] + 1 } (j < i, w(i) > w(j))
        */

        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }

                return o1[0] - o2[0];
            }
        });

        int n = envelopes.length, ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++) {
            dp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}