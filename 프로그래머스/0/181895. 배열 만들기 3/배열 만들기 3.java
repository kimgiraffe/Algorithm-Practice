class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int len1 = intervals[0][1] - intervals[0][0] + 1; // 3
        int len2 = intervals[1][1] - intervals[1][0] + 1; // 5
        
        int[] answer = new int[len1 + len2];
        
        for (int idx = 0; idx < len1; idx++) {
            answer[idx] = arr[intervals[0][0] + idx];
        }
        
        for (int idx = len1; idx < len1 + len2; idx++) {
            answer[idx] = arr[intervals[1][0]++];
        }
        
        return answer;
    }
}