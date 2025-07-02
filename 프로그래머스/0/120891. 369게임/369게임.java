class Solution {
    public int solution(int order) {
        int answer = 0;
        
        while (order > 0) {
            int d = order % 10;
            if (d == 3 || d == 6 || d == 9) {
                answer++;
            }
            order /= 10;
        }
        
        return answer;
    }
}