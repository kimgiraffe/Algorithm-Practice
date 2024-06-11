import java.util.Stack;

class Solution {
    static int tableSize;
    static StringBuilder sb;
    static Stack<Integer> stack;
    
    public String solution(int n, int k, String[] cmd) {
        tableSize = n;
        sb = new StringBuilder();
        stack = new Stack<>();
        
        for(String c : cmd) {
            char op = c.charAt(0);
            if(op == 'U') {
                k -= Integer.parseInt(c.substring(2));
            } else if(op == 'D') {
                k += Integer.parseInt(c.substring(2));
            } else if(op == 'C') {
                stack.push(k); // 현재 선택된 행 삭제
                tableSize--;
                if(k == tableSize) { // 삭제된 행이 가장 마지막 행인 경우
                    k--; // 바로 윗 행 선택
                }
            } else if(op == 'Z') {
                if(stack.pop() <= k) {
                    k++;
                }
                tableSize++;
            }
        }
        
        for(int idx = 0; idx < tableSize; idx++) {
            sb.append("O");
        }
        
        while(!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }
        
        return sb.toString();
    }
}