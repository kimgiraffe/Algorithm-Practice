class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        
        for(int idx = 0; idx < n/k; idx++) {
            answer[idx] = k * (idx + 1);
        }
        
        return answer;
    }
}