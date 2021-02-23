class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < n; i ++) {
            if (!check(matrix, 0, i)) {
                return false;
            }
        }

        for (int i = 1; i < m; i ++) {
            if (!check(matrix, i, 0)) {
                return false;
            }
        }

        return true;
    }

    private boolean check(int[][] matrix, int x, int y) {
        int n = matrix[x][y];
        while (x < matrix.length && y < matrix[0].length) {
            if (n != matrix[x][y]) {
                return false;
            }

            x += 1;
            y += 1;
        }

        return true;
    }
}