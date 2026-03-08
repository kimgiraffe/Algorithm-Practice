class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int min = Math.min(sides[0], sides[1]);
        int max = Math.max(sides[0], sides[1]);

        int sum = max + min;
        
        for (int i = 0; i < sum; i++) {
            if(i + min > max) {
                answer++;
            }
        }
        
        return answer;
    }
}