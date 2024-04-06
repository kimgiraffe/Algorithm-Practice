import java.util.*;

class Solution {
    static Queue<Integer> queue = new ArrayDeque<>();
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(int[] progresses, int[] speeds) {
        // 각 작업의 배포 가능한 일 구하기
        for(int idx = 0; idx < progresses.length; idx++) {
            if((100 - progresses[idx]) % speeds[idx] == 0) {
                queue.offer((100 - progresses[idx]) / speeds[idx]);       
            } else {
                queue.offer((100 - progresses[idx]) / speeds[idx] + 1);
            }
        }
        
        while(!queue.isEmpty()) {
            int count = 1;
            int day = queue.poll();
            
            while(!queue.isEmpty() && queue.peek() <= day) {
                queue.poll();
                count++;
            }
            list.add(count);
        }
        
        int[] answer = new int[list.size()];

        for(int idx = 0; idx < list.size(); idx++) {
            answer[idx] = list.get(idx);
        }
        
        return answer;
    }
}