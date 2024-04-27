import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        int[] copiedArray = emergency.clone();
        Arrays.sort(copiedArray);
        for(int idx = 0; idx < emergency.length; idx++) {
            for(int j = 0; j < copiedArray.length; j++) {
                if(copiedArray[j] == emergency[idx]) {
                    answer[idx] = emergency.length - j;
                }
            }
        }
        
        return answer;
        
    }
}