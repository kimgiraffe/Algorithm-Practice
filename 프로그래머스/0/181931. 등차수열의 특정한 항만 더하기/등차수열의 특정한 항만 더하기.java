class Solution {
    static int[] arr;
    static int n;
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        n = included.length;
        arr = new int[n + 1];
        for(int idx = 1; idx <= n; idx++) {
            arr[idx] = a + d * (idx - 1);
        }
        
        for(int idx = 1; idx <= n; idx++) {
            if(included[idx-1]) {
                answer += arr[idx];
            }
        }
        
        return answer;
    }
}