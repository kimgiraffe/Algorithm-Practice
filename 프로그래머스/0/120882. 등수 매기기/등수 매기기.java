class Solution {
    public int[] solution(int[][] score) {
        int len = score.length;
        int[] sum = new int[len];
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            sum[i] = score[i][0] + score[i][1];
        }
                               
        for (int i = 0; i < len; i++) {
            answer[i] = 1;
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (sum[i] < sum[j]) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}