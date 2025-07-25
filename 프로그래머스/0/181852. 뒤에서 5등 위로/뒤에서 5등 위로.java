import java.util.*;

class Solution {
    static List<Integer> list;
    public int[] solution(int[] num_list) {
        list = new ArrayList<>();
        
        Arrays.sort(num_list);
        
        for (int num : num_list) {
            list.add(num);
        }
        
        list.subList(0, 5).clear();
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}