import java.util.*;

class Solution {
    static int[] count;
    public String solution(String s) {
        String answer = "";
        count = new int[26];
        
        for (int idx = 0; idx < s.length(); idx++) {
            count[s.charAt(idx) - 'a']++;
        }
        
        for (int idx = 0; idx < count.length; idx++) {
            if(count[idx] == 1) {
                answer += (char)('a' + idx);
            }
        }
        
        return answer;
    }
}