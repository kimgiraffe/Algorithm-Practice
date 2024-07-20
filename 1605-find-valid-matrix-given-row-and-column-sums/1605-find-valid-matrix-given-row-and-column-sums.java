class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r = rowSum.length;
        int c = colSum.length;
        int[][] matrix = new int[r][c];
        for (int i = 0, j = 0; i < r && j < c; i += (rowSum[i] == 0 ? 1 : 0), j += (colSum[j] == 0 ? 1 : 0)) {
            int x = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = x;
            rowSum[i] -= x;
            colSum[j] -= x;
        }

        return matrix;
    }
}