import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        for (int idx = 0; idx < str_list.length; idx++) {
            if (str_list[idx].equals("l")) {
                return Arrays.copyOfRange(str_list, 0, idx);
            } else if (str_list[idx].equals("r")) {
                return Arrays.copyOfRange(str_list, idx + 1, str_list.length);
            }
        }
        
        return new String[0];
    }
}