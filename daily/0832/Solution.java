class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        return reverse(overturn(A));
    }

    private int[][] overturn(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] B = new int[m][n];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                B[i][j] = A[i][n - j - 1];
            }
        }

        return B;
    }

    private int[][] reverse(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] B = new int[m][n];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                B[i][j] = A[i][j] ^ 1;
            }
        }

        return B;
    }
}