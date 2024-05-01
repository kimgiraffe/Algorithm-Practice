import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Double> failMap = new HashMap<>();
        Double totalUser = (double) stages.length;
        
        for(int idx=0; idx<stages.length; idx++){
            map.put(stages[idx], map.getOrDefault(stages[idx], 0)+1);
        }
        
        for(int idx=1; idx<=N; idx++){
            if(map.containsKey(idx)){
                failMap.put(idx, map.get(idx)/totalUser);
                totalUser -= map.get(idx);
            }else{
                failMap.put(idx, 0.0);
            }
        }
        
        List<Integer> sortStages = new ArrayList<>(failMap.keySet());
        Collections.sort(sortStages, (s1, s2) -> failMap.get(s2).compareTo(failMap.get(s1)));
        
        for(int idx = 0; idx < N; idx++){
            answer[idx] = sortStages.get(idx);
        }
        
        return answer;
    }
}