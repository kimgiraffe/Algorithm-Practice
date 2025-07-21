import java.util.*;

class Solution {
    public static Set<String> set;
        
    public String[] solution(String my_string) {
        set = new HashSet<String>();
        for (int idx = 0; idx < my_string.length(); idx++) {
            set.add(my_string.substring(idx, my_string.length()));
        }
        
        String[] answer = set.toArray(new String[0]);
        Arrays.sort(answer);
        
        return answer;
    }
}