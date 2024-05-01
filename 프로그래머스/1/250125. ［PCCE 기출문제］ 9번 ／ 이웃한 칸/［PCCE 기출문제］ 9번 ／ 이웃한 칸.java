class Solution {
    static int n;
    static int count;
    static final int[] dh = {0, 1, -1, 0};
    static final int[] dw = {1, 0, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        n = board.length;
        for(int i = 0; i < 4; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            
            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                if(board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}