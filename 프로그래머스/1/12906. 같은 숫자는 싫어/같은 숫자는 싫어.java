import java.util.*;

public class Solution {
    static Stack<Integer> stack = new Stack<>();
    
    public int[] solution(int []arr) {
        for(int idx = 0; idx < arr.length; idx++) {
            if(stack.isEmpty()) {
                stack.push(arr[idx]);
            }
            else if(stack.peek() != arr[idx]) {
                stack.push(arr[idx]);
            }
        }
        
        int n = stack.size();
        int[] answer = new int[n];
        
        while(!stack.isEmpty()) {
            for(int idx = n - 1; idx >= 0; idx--) {
                answer[idx] = stack.pop();
            }
        }

        return answer;
    }
}