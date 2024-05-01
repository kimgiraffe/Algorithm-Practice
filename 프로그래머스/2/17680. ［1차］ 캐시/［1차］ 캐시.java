import java.util.*;

class Solution {
    static List<String> list;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        list = new LinkedList<>();
        
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for(int idx = 0; idx < cities.length; idx++) {
            String city = cities[idx].toUpperCase();
            
            if(list.size() < cacheSize) {
                if(list.contains(city)) {
                    list.remove(city);
                    list.add(city);
                    answer++;
                } else {
                    list.add(city);
                    answer += 5;
                }
            } else {
                if(list.contains(city)) {
                    list.remove(city);
                    list.add(city);
                    answer++;
                } else {
                    list.remove(0);
                    list.add(city);
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}