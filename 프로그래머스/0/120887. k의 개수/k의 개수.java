class Solution {
    public int count(int num, int k) {
        int result = 0;
        while (num > 0) {
            int d = num % 10;
            if(d == k) {
                result++;
            }
            num /= 10;
        }
        
        return result;
    }
    
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int num = i; num <= j; num++) {
            answer += count(num, k);
        }
        
        return answer;
    }
}