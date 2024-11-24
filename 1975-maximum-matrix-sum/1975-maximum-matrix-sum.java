class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        long sum = 0;
        int negative = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) {
                    negative++;
                }
                int abs = Math.abs(matrix[i][j]);
                min = Math.min(min, abs);
                sum += abs;
            }
        }

        if (negative % 2 == 0) {
            return sum;
        }

        return sum - 2 * min;
    }
}