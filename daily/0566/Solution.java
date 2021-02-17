class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }

        int[][] newMatrix = new int[r][c];
        int index = 0;
        for (int[] row : nums) {
            for (int item : row) {
                newMatrix[index / c][index % c] = item;
                index ++;
            }
        }

        return newMatrix;
    }
}