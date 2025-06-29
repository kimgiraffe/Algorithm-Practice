import java.util.*;

class Solution {
    static int size, idx;
    
    public int[] solution(String my_string) {
        int[] answer = {};
        
        for (int i = 0; i < my_string.length(); i++) {
            if(my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
                size++;
            }
        }
        
        answer = new int[size];
        
        for (int i = 0; i < my_string.length(); i++) {
            if(my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
                answer[idx++] = my_string.charAt(i) - '0';
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}