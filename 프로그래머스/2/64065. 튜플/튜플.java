import java.util.*;

class Solution {
    static List<Integer> tuple;
    
    public int[] solution(String s) {
        tuple = new ArrayList<>();
        
        String[] input = s.split("\\},\\{");
        input[0] = input[0].replace("{{", "");
        input[input.length - 1] = input[input.length - 1].replace("}}", "");
        
        Arrays.sort(input, (s1, s2) -> s1.length() - s2.length());
        
        for(String str : input) {
            String[] splitted = str.split(",");
            for(String e : splitted) {
                int num = Integer.parseInt(e);
                if(!tuple.contains(num)) {
                    tuple.add(num);
                }
            }
        }
        
        int[] answer = new int[tuple.size()];
        for(int idx = 0; idx < tuple.size(); idx++) {
            answer[idx] = tuple.get(idx);
        }
        return answer;
    }
}