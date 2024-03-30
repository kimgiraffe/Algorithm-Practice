import java.util.*;

class Solution {
    
    static int n;
    
    public int[] solution(int[] prices) {
        n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack();
        
        for(int idx = 0; idx < n; idx++) {
            while(!stack.isEmpty() && prices[idx] < prices[stack.peek()]) {
                answer[stack.peek()] = idx - stack.peek();
                stack.pop();
            }
            stack.push(idx);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.peek()] = n - stack.peek() - 1;
            stack.pop();
        }
        
        return answer;
    }
}