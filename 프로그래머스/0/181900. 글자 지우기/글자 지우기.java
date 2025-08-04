import java.util.*;

class Solution {
    static Set<Integer> set;
    public String solution(String my_string, int[] indices) {
        set = new HashSet<>();
        for (int idx : indices) {
            set.add(idx);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (!set.contains(i)) {
                sb.append(my_string.charAt(i));
            }
        }
        
        return sb.toString();
    }
}