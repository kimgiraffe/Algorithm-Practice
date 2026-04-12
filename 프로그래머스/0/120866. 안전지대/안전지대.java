class Solution {
    static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    static boolean[][] danger;
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        danger = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int d = 0; d < 9; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            danger[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!danger[i][j]) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}