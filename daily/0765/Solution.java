import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }

        return p[x];
    }

    public void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    public int minSwapsCouples(int[] row) {
        p = new int[row.length / 2];

        for (int i = 0; i < row.length / 2; i ++) {
            p[i] = i;
        }

        for (int i = 0; i < row.length; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }

        int count = 0;
        for (int i = 0; i < row.length / 2; i ++) {
            if (i == find(i)) {
                count ++;
            }
        }

        return row.length / 2 - count;
    }
}