import java.util.*;

class Solution {
    static int M, N;
    static int[][] copied;
    static int count;
    static class Pos {
        int row;
        int col;
        
        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        @Override
        public String toString() {
            return this.row + "," +  this.col;
        }
    }
    
    static List<Pos> list;
    
    static int[][] rotate90(int[][] key) {
        int[][] rotated = new int[M][M];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                rotated[i][j] = key[M - j - 1][i];
            }
        }
        
        return rotated;
    }
    
    static boolean isInRange(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
    
    static boolean check(int[][] key, int[][] lock) {
        list = new ArrayList<>();
        for(int row = 0; row < M; row++) {
            for(int col = 0; col < M; col++) {
                if(key[row][col] == 1) {
                    list.add(new Pos(row, col));
                }
            }
        }
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                if(lock[row][col] == 1) {
                    continue;
                }
                for(Pos target : list) {
                    boolean flag = true;
                    int sum = 1;
                    for(Pos pos : list) {
                        int diffRow = pos.row - target.row;
                        int diffCol = pos.col - target.col;
                        
                        if(diffRow == 0 && diffCol == 0) {
                            continue;
                        }
                        
                        int checkRow = row + diffRow;
                        int checkCol = col + diffCol;
                        
                        if(!isInRange(checkRow, checkCol)) {
                            continue;
                        }
                        
                        if(lock[checkRow][checkCol] == 1) {
                            flag = false;
                            break;
                        } else {
                            sum++;
                        }
                    }
                    
                    if(flag && sum == count) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        list = new ArrayList<>();
        copied = key.clone();
        
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                if(lock[row][col] == 0) {
                    count++;
                }
            }
        }
        
       
        System.out.println(list.toString());
        
        if(count == 0) {
            return true;
        }
        
        for(int i = 0; i < 4; i++) {
            if(i != 0) {
                copied = rotate90(copied);
                // System.out.println(Arrays.deepToString(copied));
            }
            
            if(check(copied, lock)) {
                return true;
            }
        }
        
        return false;
    }
}