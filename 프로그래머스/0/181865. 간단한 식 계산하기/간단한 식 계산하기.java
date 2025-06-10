class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String[] s = binomial.split(" ");
        
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);
        String op = s[1];
        switch(op) {
            case "+" : answer = a + b;
                break;
            case "-" : answer = a - b;
                break;
            case "*" : answer = a * b;
                break;
            default : answer = 0;
                break;
        }
        
        return answer;
    }
}