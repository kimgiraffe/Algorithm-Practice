import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int remainder = score.length % m;
        
        Arrays.sort(score);
        
        for(int idx = 0; idx < score.length / m; idx++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++) {
                min = Math.min(min, score[j + m * idx + remainder]);                
            }
            answer += min * m;
        }
        
        return answer;
    }
}