import java.util.*;

class Solution {
    static Map<Character, Integer> map;
    
    public String solution(String my_string) {
        map = new LinkedHashMap<>();
        
        for (int idx = 0; idx < my_string.length(); idx++) {
            Character c = my_string.charAt(idx);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            }
        }
                
        StringBuilder sb = new StringBuilder();
        map.keySet().stream().forEach(sb::append);
        
        return sb.toString();
    }
}