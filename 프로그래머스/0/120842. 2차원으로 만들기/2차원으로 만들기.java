class Solution {
    public int[][] solution(int[] num_list, int n) {
        int rowSize = num_list.length / n;
        int idx = 0;
        int[][] answer = new int[rowSize][n];
        
        for (int r = 0; r < rowSize; r++) {
            for(int c = 0; c < n; c++) {
                answer[r][c] = num_list[idx++];
            }
        } 
        
        return answer;
    }
}