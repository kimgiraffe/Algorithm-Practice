import java.util.*;

class Solution {
    static Stack<Integer> stack;
    
    public int[] solution(int[] arr) {
        stack = new Stack<>();
        
        int i = 0;
        
        while (i < arr.length) {
            if (stack.isEmpty()) {
                stack.push(arr[i++]);
            } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.push(arr[i++]);
            } else if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
        }
        
        int[] stk = new int[stack.size()];
        
        int idx = stack.size() - 1;
        
        while(!stack.isEmpty()) {
            stk[idx--] = stack.pop();
        }
        
        return stk;
    }
}