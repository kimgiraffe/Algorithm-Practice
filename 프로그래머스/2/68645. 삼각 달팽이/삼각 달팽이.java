import java.util.*;

class Solution {
    // ↓, →, ↖
    static final int[] DELTA_ROW = {1, 0, -1};
    static final int[] DELTA_COL = {0, 1, -1};
    
    static int[] answer;
    static int[][] snail;
    static boolean[][] visited;
    
    public static void bfs(int n) {
        int dir = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        snail[0][0] = 1;
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            int nextRow = cur[0] + DELTA_ROW[dir];
            int nextCol = cur[1] + DELTA_COL[dir];
            
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                if(dir < 2) {
                    dir++;
                }
                queue.offer(new int[]{cur[0], cur[1]});
                continue;
            }
            
            if(visited[nextRow][nextCol]) {
                dir = (dir + 1) % 3;
                queue.offer(new int[]{cur[0], cur[1]});
                continue;
            }
            
            visited[nextRow][nextCol] = true;
            snail[nextRow][nextCol] = snail[cur[0]][cur[1]] + 1;
            if(snail[nextRow][nextCol] == n * (n + 1) / 2) {
                return;
            }
            
            queue.offer(new int[]{nextRow, nextCol});
        }
    }
    
    public static void fill(int n) {
        int answerIdx = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(snail[r][c] != 0) {
                    answer[answerIdx++] = snail[r][c];
                }
            }
        }
    }
    
    public int[] solution(int n) {
        if(n == 1) {
            return new int[]{1};
        }
        answer = new int[n * (n + 1) / 2];
        snail = new int[n][n];
        visited = new boolean[n][n];
        
        bfs(n);
        fill(n);
        
        return answer;
    }
}