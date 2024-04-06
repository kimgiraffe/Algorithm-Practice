import java.util.*;

class Solution {
    static Stack<Character> stack = new Stack();
    
    boolean solution(String s) {
        boolean answer = true;
        
        for(int idx = 0; idx < s.length(); idx++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(idx));
            } else {
                if(stack.peek() == '(') {
                    if(s.charAt(idx) == ')') {
                        stack.pop();
                    } else {
                        stack.push('(');
                    }
                } else {
                    if(stack.peek() == ')') {
                        answer = false;
                        break;
                    }
                }
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}