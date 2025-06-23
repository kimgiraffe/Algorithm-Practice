class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();
        
        for (int q = 0; q < queries.length; q++) {
            int s = queries[q][0];
            int e = queries[q][1];
            int k = queries[q][2];
            
            for(int i = s; i <= e; i++) {
                if (i % k == 0) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}