import java.util.*;
class Solution {
    static Stack<Integer> stack;
    public int solution(int[] ingredient) {
        int answer = 0;
        stack = new Stack<>();
        for(int idx = 0; idx < ingredient.length; idx++) {
            stack.push(ingredient[idx]);
        
            if(stack.size() >= 4) {
                int size = stack.size();
                if(stack.get(size - 1) == 1 && stack.get(size - 2) == 3 && stack.get(size - 3) == 2 && stack.get(size - 4) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }
}