import java.util.*;

class Solution {
    static final int[] DELTA_X = {0, 1, 0, -1};
    static final int[] DELTA_Y = {1, 0, -1, 0};
    static Map<Character, Integer> map;
    static HashSet<String> set = new HashSet<>();
    
    static boolean isInRange(int row, int col) {
        return row >= -5 && row <= 5 && col >= -5 && col <= 5;
    }
    
    public int solution(String dirs) {
        int answer = 0;
        int r = 0, c = 0;

        map = new HashMap<>();
        map.put('U', 0);
        map.put('R', 1);
        map.put('D', 2);
        map.put('L', 3);
        
        for(int idx = 0; idx < dirs.length(); idx++) {
            int dir = map.get(dirs.charAt(idx));
            
            int nextR = r + DELTA_X[dir];
            int nextC = c + DELTA_Y[dir];
            
            if(!isInRange(nextR, nextC)) {
               continue;
            }
            
            if(dir < 2) {
                set.add(nextR+","+nextC+","+r+","+c);
            } else {
                set.add(r+","+c+","+nextR+","+nextC);
            }
            r = nextR;
            c = nextC;
        }
       
        return set.size();
    }
}