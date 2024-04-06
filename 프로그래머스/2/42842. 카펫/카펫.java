class Solution {
    public int[] solution(int brown, int yellow) {
        for(int row = 1; row <= brown + yellow; row++) {
            for(int col = 1; col <= row; col++) {
                if(row * col == brown + yellow && (row - 2) * (col - 2) == yellow) {
                    return new int[] {row, col};
                }
            }
        }
        return new int[] {0, 0};
    }
}