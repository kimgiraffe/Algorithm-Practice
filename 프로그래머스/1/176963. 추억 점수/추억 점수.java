import java.util.*;
class Solution {
    static Map<String, Integer> map;
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        map = new HashMap<>();
        int[] answer = new int[photo.length];
        
        for(int idx = 0; idx < name.length; idx++) {
            map.put(name[idx], yearning[idx]);
        }
        
        for(int idx = 0; idx < photo.length; idx++) {
            int score = 0;
            for(String str : photo[idx]) {
                score += map.getOrDefault(str, 0);
            }
            answer[idx] = score;
        }
        
        return answer;
    }
}