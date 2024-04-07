import java.util.*;

class Solution {
    static Map<Integer, Integer> map1 = new HashMap<>();
    static Map<Integer, Integer> map2 = new HashMap<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        
        for(int idx = 0; idx < topping.length; idx++) {
            map1.put(topping[idx], map1.getOrDefault(topping[idx], 0) + 1);
        }
        
        for(int idx = 0; idx < topping.length; idx++) {
            map2.put(topping[idx], map2.getOrDefault(topping[idx], 0) + 1);
            
            if(map1.get(topping[idx]) - 1 == 0) {
                 map1.remove(topping[idx]);
            } else {
                map1.put(topping[idx], map1.get(topping[idx]) - 1);
            }
            
            if(map1.size() == map2.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}