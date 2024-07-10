import java.util.*;

class Solution {
    static int M, N; // key, lock 크기
    static int count;
    static final int[] DELTA_ROW = {-1, 0, 1, 0}; // 상, 하
    static final int[] DELTA_COL = {0, 1, 0, -1}; // 우, 좌
    
    static class Pos {
        int row;
        int col;
        
        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    static boolean isInRange(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
    
    static int[][] rotate90 (int[][] key) {
        int[][] rotated = new int[M][M];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                rotated[i][j] = key[M - j -1][i];
            }
        }
        
        return rotated;
    }
    
    static boolean check(int[][] key, int[][] lock) {
        List<Pos> list = new ArrayList<>();
        
        // key의 돌기 부분 찾기
        for(int row = 0; row < M; row++) {
            for(int col = 0; col < M; col++) {
                if(key[row][col] == 1) {
                    list.add(new Pos(row, col));
                }
            }
        }
        
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                if(lock[row][col] == 1) { // 자물쇠의 돌기 부분인 경우...
                    continue;
                }
                for(Pos target : list) {
                    boolean flag = true;
                    int sum = 1;
                    for(Pos pos : list) {
                        int nextRow = pos.row - target.row;
                        int nextCol = pos.col - target.col;
                        if(nextRow == 0 && nextCol == 0) { // 자기 자신
                            continue;
                        }
                        
                        int checkRow = row + nextRow;
                        int checkCol = col + nextCol;
                        if(!isInRange(checkRow, checkCol)) {
                            continue;
                        }
                        
                        if(lock[checkRow][checkCol] == 1) { // 자물쇠의 돌기 부분
                            flag = false; // 열 수 없음
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
        boolean answer = true;
        
        M = key.length;
        N = lock.length;
        
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                if(lock[row][col] == 0) {
                    count++;
                }
            }
        }
        
        if(count == 0) {
            return true;
        }
        
        int[][] copied = key.clone();
        
        for(int i = 0; i < 4; i++) {
            if(i != 0) {
                copied = rotate90(copied);
            }
            
            if(check(copied, lock)) {
                return true;
            }
        }
        
        return false;
    }
}