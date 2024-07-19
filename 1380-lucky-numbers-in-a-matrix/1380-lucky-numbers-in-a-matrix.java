class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> luckyNumber = new ArrayList<>();

        List<Integer> minRow = new ArrayList<>();
        List<Integer> maxCol = new ArrayList<>();

        for (int row = 0; row < m; row++) {
            int min = Integer.MAX_VALUE;
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] < min) {
                    min = matrix[row][col];
                }
            }
            minRow.add(min);
        }

        for (int col = 0; col < n; col++) {
            int max = 0;
            for (int row = 0; row < m; row++) {
                if (matrix[row][col] > max) {
                    max = matrix[row][col];
                }
            }
            maxCol.add(max);
        }

        for (int min : minRow) {
            for (int max : maxCol) {
                if (min == max) {
                    luckyNumber.add(min);
                }
            }
        }

        return luckyNumber;
    }
}