import java.util.*;

class Solution {
    static final int[] DELTA_ROW = {-1, 0, 1, 0};
    static final int[] DELTA_COL = {0, 1, 0, -1};
    
    static boolean[][] visited;
    static int n, m;
    static int startR, startC, endR, endC, leverR, leverC;
    static int d1, d2;
    
    static class Pos {
        int r;
        int c;
        int d;
        
        public Pos (int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    
    static int bfs(String[] maps, int sR, int sC, int eR, int eC) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(sR, sC, 0));
        visited = new boolean[n][m];
        visited[sR][sC] = true;
        
        while(!queue.isEmpty()) {
            Pos cur = queue.poll();
            
            if(cur.r == eR && cur.c == eC) {
                return cur.d;
            }
            
            for(int dir = 0; dir < 4; dir++) {
                int nextR = cur.r + DELTA_ROW[dir];
                int nextC = cur.c + DELTA_COL[dir];
                
                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;
                if(visited[nextR][nextC]) continue;
                if(maps[nextR].charAt(nextC) == 'X') continue;
                
                visited[nextR][nextC] = true;
                queue.offer(new Pos(nextR, nextC, cur.d + 1));
                
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(maps[row].charAt(col) == 'S') {
                    startR = row;
                    startC = col;
                }
                if(maps[row].charAt(col) == 'E') {
                    endR = row;
                    endC = col;
                }
                if(maps[row].charAt(col) == 'L') {
                    leverR = row;
                    leverC = col;
                }
            }
        }
        
        d1 = bfs(maps, startR, startC, leverR, leverC);
        d2 = bfs(maps, leverR, leverC, endR, endC);
        
        if(d1 == -1 || d2 == -1) {
            return -1;
        } else {
            return d1 + d2;
        }
    }
}