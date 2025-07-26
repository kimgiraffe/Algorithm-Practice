class Solution {
    public int solution(int[] arr, int idx) {
        int answer = 0;
        
        for (int s = idx; s < arr.length; s++) {
            if (arr[s] == 1) {
                return s;
            }
        }
        
        return -1;
    }
}