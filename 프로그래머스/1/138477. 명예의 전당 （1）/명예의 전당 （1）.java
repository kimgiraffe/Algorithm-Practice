import java.util.*;

class Solution {
    static int min = 2000;
    
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> honors = new ArrayList<>();
        
        for(int idx = 0; idx < score.length; idx++) {
            if(idx < k) {
                honors.add(score[idx]);
            } else {
                if(score[idx] > honors.get(0)) {
                    honors.remove(0);
                    honors.add(score[idx]);
                }
            }
            Collections.sort(honors);
            answer[idx] = honors.get(0);
        }
        
        return answer;
    }
}