import java.util.*;

class Solution {
    static Map<String, Integer> map;
    static List<Integer> result;
    
    static int init() {
        int num = 1; // 색인 번호
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(String.valueOf(ch), num++);
        }
        
        return num;
    }
    
    public int[] solution(String msg) {

        map = new HashMap<>();
        result = new ArrayList<>();
        
        int value = init(); // 초기화
        
        for(int i = 0; i < msg.length(); i++) {
            String str = "";
            // 사전에 등록된 가장 긴 문자열 찾기
            while(i < msg.length() && map.containsKey(str + msg.charAt(i))) {
                str += msg.charAt(i++);
            }
            
            // 찾은 문자열의 색인 번호 추가
            result.add(map.get(str));
            
            // 남은 문자가 있는 경우...
            if(i < msg.length()) {
                // 다음 문자를 더해 사전에 등록
                map.put(str + msg.charAt(i--), value++);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}