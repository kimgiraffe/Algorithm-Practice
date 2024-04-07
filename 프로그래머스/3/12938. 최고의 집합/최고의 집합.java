class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        if(n > s) {
            return new int[]{-1};
        }
        
        int quotient = s / n;
        int remainder = s % n;
        int index = n - 1;
        
        answer = new int[n];
        for(int idx = 0; idx < n; idx++) {
            answer[idx] = quotient;
        }
        
        for(int idx = 0; idx < remainder; idx++) {
            answer[index--]++;
        }
        
        return answer;
    }
}