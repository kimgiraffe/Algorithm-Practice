class Solution {
    public int maximumGain(String s, int x, int y) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            StringBuilder sb = new StringBuilder();
            for(char ch : s.toCharArray()) {
                if(ch == 'a') {
                    sb.append('b');
                } else if(ch == 'b') {
                    sb.append('a');
                } else {
                    sb.append('c');
                }
            }
            s = sb.toString();
        }

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'a' && ch == 'b') {
                stack.pop();
                answer += x;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        for (char ch : sb.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && ch == 'a') {
                stack.pop();
                answer += y;
            } else {
                stack.push(ch);
            }
        }

        return answer;
    }
}