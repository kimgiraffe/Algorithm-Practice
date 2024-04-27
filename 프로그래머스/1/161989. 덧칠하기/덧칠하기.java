class Solution {
    public int solution(int n, int m, int[] section) {
        int start = section[0];
        int end = section[0] + m - 1;
        int answer = 0;
        
        for(int idx = 0; idx < section.length; idx++) {
            if(section[idx] > start && section[idx] <= end) {
                continue;
            }
            else {
                start = section[idx];
                end = section[idx] + m - 1;
                answer++;
            }
        }
        return answer;
    }
}