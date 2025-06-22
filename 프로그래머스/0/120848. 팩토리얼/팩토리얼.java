class Solution {
    
    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        for (int num = 1; num <= 10; num++) {
            if (factorial(num) > n) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
}