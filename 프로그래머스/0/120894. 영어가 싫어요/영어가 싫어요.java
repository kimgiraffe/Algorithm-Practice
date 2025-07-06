import java.util.*;

class Solution {
    static Map<String, String> map;
    public long solution(String numbers) {
        long answer = 0;
        map = new LinkedHashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("zero", "0");
        
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        
        for (char c : numbers.toCharArray()) {
            tmp.append(c);
            for (String word : map.keySet()) {
                if(tmp.toString().equals(word)) {
                    sb.append(map.get(word));
                    tmp.setLength(0);
                    break;
                }
            }
        }
        
        return Long.parseLong(sb.toString());
    }
}