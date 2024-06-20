import java.util.*;

class Solution {
    static int rowSize, colSize;
    static int min = 101;
    
    static void flipRow(int[][] beginning, int row) {
        for(int i = 0; i < beginning[0].length; i++) {
            beginning[row][i] = 1 - beginning[row][i];
        }
    }
    
    static int countDiff(int[][] beginning, int[][] target, int col) {
        int diff = 0;
        for(int i = 0; i < beginning.length; i++) {
            if(beginning[i][col] != target[i][col]) {
                diff++;
            }
        }
        return diff;
    }
    
    static void dfs(int row, int count, int[][] beginning, int[][] target) {
        if(row == rowSize) {
            int result = count;
            for(int col = 0; col < colSize; col++) {
                int diff = countDiff(beginning, target, col);
                if(diff == rowSize) {
                    result++;
                } else if(diff != 0) {
                    return;
                }
            }
            min = Math.min(min, result);
            return;
        }
        
        flipRow(beginning, row);
        dfs(row + 1, count + 1, beginning, target);
        
        flipRow(beginning, row);
        dfs(row + 1, count, beginning, target);
    }
    
    public int solution(int[][] beginning, int[][] target) {
        rowSize = beginning.length;
        colSize = beginning[0].length;
        
        dfs(0, 0, beginning, target);
        
        return min == 101 ? -1 : min;
    }
}