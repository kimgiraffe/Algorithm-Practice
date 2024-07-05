import java.util.*;

class Solution {
    static HashMap<String, String> map;
    static List<String> result;
    public String[] solution(String[] record) {
        map = new HashMap<>();
        result = new ArrayList<>();
        
        for(String r : record) {
            String[] input = r.split(" ");
            if(!input[0].equals("Leave")) {
                map.put(input[1], input[2]);
            }
        }
        
        for(String r : record) {
            String[] input = r.split(" ");
            if(input[0].equals("Enter")) {
                String nickname = map.get(input[1]);
                result.add(nickname+"님이 들어왔습니다.");
            } else if(input[0].equals("Leave")) {
                String nickname = map.get(input[1]);
                result.add(nickname+"님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[result.size()];
        for(int idx = 0; idx < result.size(); idx++) {
            answer[idx] = result.get(idx);
        }
        
        return answer;
    }
}