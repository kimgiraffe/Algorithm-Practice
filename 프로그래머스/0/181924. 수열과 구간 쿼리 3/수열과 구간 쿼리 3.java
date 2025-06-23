class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();
        
        for (int q = 0; q < queries.length; q++) {
            int tmp = answer[queries[q][0]];
            answer[queries[q][0]] = answer[queries[q][1]];
            answer[queries[q][1]] = tmp;
        }
        
        return answer;
    }
}