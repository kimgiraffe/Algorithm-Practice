import java.util.*;

class Solution {
    static int[][] map;
    static int maxX, maxY;
    static int posX, posY;
    
    static Map<String, int[]> moveMap = Map.of(
        "left", new int[]{-1, 0},
        "right", new int[]{1, 0},
        "up", new int[]{0, 1},
        "down", new int[]{0, -1}
    );
    
    static boolean isInRange(int x, int y) {
        return x <= maxX && x >= -maxX && y <= maxY && y >= -maxY;
    }
    
    public int[] solution(String[] keyinput, int[] board) {
        maxX = board[0] / 2;
        maxY = board[1] / 2;
        map = new int[board[0] / 2][board[1] / 2];
       
        for (String s : keyinput) {
            int dx = moveMap.get(s)[0];
            int dy = moveMap.get(s)[1];
            int nextX = posX + dx;
            int nextY = posY + dy;

            if (isInRange(nextX, nextY)) {
                posX = nextX;
                posY = nextY;
            }
        }
        
        return new int[] {posX, posY};
    }
}