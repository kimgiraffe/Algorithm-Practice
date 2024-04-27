class Solution {
    public double solution(int balls, int share) {
        double answer = 1;
        
        for(int idx = 0; idx < share; idx++) {
            answer = answer * (balls - idx) / (idx + 1);
        }
        
        return answer;
    }
}