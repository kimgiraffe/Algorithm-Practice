class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            
            for (int idx = s; idx <= e; idx++) {
                arr[idx]++;
            }
        }
        
        return arr;
    }
}