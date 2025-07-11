import java.util.*;

class Solution {
    static List<Integer> list;
    
    public int[] solution(int[] num_list, int n) {
        list = new ArrayList<>();
        
        for (int idx = n; idx < num_list.length; idx++) {
            list.add(num_list[idx]);
        }
        
        for (int idx = 0; idx < n; idx++) {
            list.add(num_list[idx]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}