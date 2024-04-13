import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ");
        for(int idx = 0; idx < words.length; idx++) {
            if(words[idx].length() == 0) {
                answer += " ";
            } else {
                answer += words[idx].substring(0, 1).toUpperCase();
                answer += words[idx].substring(1, words[idx].length()).toLowerCase();
                answer += " ";
            }
        }
        
        if(s.substring(s.length() - 1, s.length()).equals(" ")) {
            return answer;
        }      
        
        return answer.substring(0, answer.length() - 1);
    }
}