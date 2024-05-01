import java.util.*;

class Solution {
    static final int[] DELTA_ROW = {1, 0, -1, 0};
    static final int[] DELTA_COL = {0, 1, 0, -1};

    static boolean[][] visited;
    static Queue<int[]> queue;
    static int bfs(int r, int c, String[] maps) {
        int sum = 0;
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            sum += maps[cur[0]].charAt(cur[1]) - '0';
            for(int dir = 0; dir < 4; dir++) {
                int nextRow = cur[0] + DELTA_ROW[dir];
                int nextCol = cur[1] + DELTA_COL[dir];
                if(nextRow >= 0 && nextRow < maps.length && nextCol >= 0 && nextCol < maps[0].length()) {
                    if(!visited[nextRow][nextCol] && maps[nextRow].charAt(nextCol) != 'X') {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        
        return sum;
    }
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        queue = new ArrayDeque<>();
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int row = 0; row < maps.length; row++) {
            for(int col = 0; col < maps[0].length(); col++) {
                if(maps[row].charAt(col) != 'X' && !visited[row][col]) {
                    answer.add(bfs(row, col, maps));
                }
            }
        }
        
        if(answer.size() == 0) {
            answer.add(-1);
        }
        Collections.sort(answer);
        return answer;
    }
}