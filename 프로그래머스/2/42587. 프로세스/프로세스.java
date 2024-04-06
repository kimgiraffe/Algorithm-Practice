import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        for(int idx = 0; idx < priorities.length; idx++) {
            pq.offer(priorities[idx]);
        }
        
        while(!pq.isEmpty()) {
            for(int idx = 0; idx < priorities.length; idx++) {
                if(pq.peek() == priorities[idx]) {
                    pq.poll();
                    answer++;
                    
                    if(location == idx) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}