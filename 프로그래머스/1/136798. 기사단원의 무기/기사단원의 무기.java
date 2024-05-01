class Solution {
    static int answer;
    
    static int countDivisor(int num) {
        int count = 0;
        for(int i = 1; i * i <= num; i++) {
            if(i * i == num) {
                count++;
            } else if(num % i == 0) {
                count += 2;
            }
        }
        return count;
    }
    static void solve(int number, int limit, int power) {
        for(int i = 1; i <= number; i++) {
            int count = countDivisor(i);
            
            if(count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
    }
    
    public int solution(int number, int limit, int power) {
        solve(number, limit, power);
        return answer;
    }
}