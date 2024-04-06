import java.util.*;

class Solution {
    static final int[] first = {1, 2, 3, 4, 5};
    static final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    static int[] count = new int[3];
    static int max;
    static int[] answer;
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(int[] answers) {
        for(int idx = 0; idx < answers.length; idx++) {
            if(first[idx % 5] == answers[idx]) {
                count[0]++;
            }
            if(second[idx % 8] == answers[idx]) {
                count[1]++;
            }
            if(third[idx % 10] == answers[idx]) {
                count[2]++;
            }
        }
        
        max = Math.max(count[0], Math.max(count[1], count[2]));
        
        for(int idx = 0; idx < 3; idx++) {
            if(max == count[idx]) {
                list.add(idx + 1);
            }
        }
        
        answer = new int[list.size()];
        
        for(int idx = 0; idx < list.size(); idx++) {
            answer[idx] = list.get(idx);
        }
        
        return answer;
    }
}