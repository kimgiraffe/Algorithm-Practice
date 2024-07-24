import java.util.*;

class Solution {
    static char[][] map;
    static int rowSize, colSize;
    static class Pos {
        int row;
        int col;
        
        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public void fill() {
        for(int row = rowSize - 1; row >= 0; row--) {
            for(int col = 0; col < colSize; col++) {
                if(map[row][col] == ' ') {
                    int r = row;
                    while(r > 0 && map[r][col] == ' ') {
                        r--;
                    }
                    if(map[r][col] != ' ') {
                        map[row][col] = map[r][col];
                        map[r][col] = ' ';
                    }
                }
            }
        }
    }
    
    public int removeBlock() {
        List<Pos> removed = new ArrayList<>();
        int count = 0;
        
        for(int row = 0; row < rowSize; row++) {
            for(int col = 0; col < colSize; col++) {
                char block = map[row][col];
                if(block == ' ') continue;
                
                if(row + 1 < rowSize && col + 1 < colSize) {
                    if(block == map[row + 1][col] && block == map[row][col + 1]
                       && block == map[row + 1][col + 1]) {
                        removed.add(new Pos(row, col));
                        removed.add(new Pos(row + 1, col));
                        removed.add(new Pos(row, col + 1));
                        removed.add(new Pos(row + 1, col + 1));
                    }
                }
            }
        }
        
        for(Pos pos : removed) {
            map[pos.row][pos.col] = ' ';
            count++;
        }
        
        return count;
    }
    
    
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        rowSize = m;
        colSize = n;
        map = new char[m][n];
        
        for(int row = 0; row < m; row++) {
            map[row] = board[row].toCharArray();
        }
        
        while(true) {
            int count = removeBlock();
            if(count == 0) {
                break;
            }
            
            fill();
        }
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(map[row][col] == ' ') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}