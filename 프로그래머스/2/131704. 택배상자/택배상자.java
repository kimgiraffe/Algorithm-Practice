import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>(); // 보조 컨테이너 벨트
    
    public int solution(int[] order) {
        int answer = 0;
        
        for(int idx = 1; idx <= order.length; idx++) {
            stack.push(idx);
            
            while(!stack.isEmpty() && stack.peek() == order[answer]) {
                stack.pop(); // 상자 내리기
                answer++;
            }
        }
        
        return answer;
    }
}