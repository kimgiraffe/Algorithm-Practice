import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static List<Integer> result;
    
    static int init() {
        int num = 1;
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(String.valueOf(ch), num++);
        }
        
        return num;
    }
    
    public int[] solution(String msg) {

        map = new HashMap<>();
        result = new ArrayList<>();
        
        int value = init();
        int index = 0;
        for(int i = 0; i < msg.length(); i++) {
            String str = "";
            while(i < msg.length() && map.containsKey(str + msg.charAt(i))) {
                str += msg.charAt(i);
                i++;
            }
            result.add(map.get(str));
            
            if(i < msg.length()) {
                map.put(str + msg.charAt(i), value++);
                i--;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}