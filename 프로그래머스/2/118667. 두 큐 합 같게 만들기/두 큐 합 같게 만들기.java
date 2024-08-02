import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long totalSum = 0;
        long q1Sum = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int idx = 0; idx < queue1.length; idx++) {
            totalSum += queue1[idx] + queue2[idx];
            q1Sum += queue1[idx];
            q1.offer(queue1[idx]);
            q2.offer(queue2[idx]);
        }
        
        if(totalSum % 2 == 1) {
            return -1;
        }
        
        long target = totalSum / 2;
        
        while(true) {
            if(answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            
            if(q1Sum == target) {
                break;
            } else if(q1Sum > target) {
                q1Sum -= q1.peek();
                q2.offer(q1.poll());
            } else {
                q1Sum += q2.peek();
                q1.offer(q2.poll());
            }
            answer++;
        }
        
        return answer;
    }
}