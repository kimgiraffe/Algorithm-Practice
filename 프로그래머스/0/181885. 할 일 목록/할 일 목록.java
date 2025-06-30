import java.util.*;

class Solution {
    static List<String> list;
    
    public String[] solution(String[] todo_list, boolean[] finished) {
        list = new ArrayList<>();
        
        for (int idx = 0; idx < todo_list.length; idx++) {
            if(!finished[idx]) {
                list.add(todo_list[idx]);
            }
        }
        
        return list.stream().toArray(String[]::new);
    }
}