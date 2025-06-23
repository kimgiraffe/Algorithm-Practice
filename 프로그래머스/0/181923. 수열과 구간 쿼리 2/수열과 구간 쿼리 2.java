class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int q = 0; q < queries.length; q++) {
            int m = 1000001;
            int start = queries[q][0];
            int end = queries[q][1];
            for(int idx = start; idx <= end; idx++) {
                if(arr[idx] > queries[q][2]) {
                    m = Math.min(m, arr[idx]);   
                }
            }
            if(m == 1000001) {
                answer[q] = -1;
            } else {
                answer[q] = m;
            }
        }
        
        return answer;
    }
}