import java.util.*;
class Solution {
    
    static String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    public String solution(String letter) {
        String answer = "";
        String[] tmp = letter.split(" ");
        
        for(int i = 0; i < tmp.length; i++) {
            for(int j = 0; j < morse.length; j++) {
                if(morse[j].equals(tmp[i])) {
                    answer+= (char) (j + 'a');
                    break;
                }
            }
        }
        
        return answer;
    }
}