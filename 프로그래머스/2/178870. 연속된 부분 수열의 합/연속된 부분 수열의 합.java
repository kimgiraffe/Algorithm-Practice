class Solution {
    static int[] sum;
    static int len = 1000001;
    static int[] answer = new int[2];
    
    static void solve(int[] sequence, int k) {
        for(int idx = 1; idx <= sequence.length; idx++) {
            int left = -1, right = -1;
            int lo = 0;
            int hi = sequence.length - idx;
            
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(sum[mid + idx] - sum[mid] >= k) {
                    if(sum[mid + idx] - sum[mid] == k) {
                        left = mid;
                        right = mid + idx - 1;
                    }
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if(left != -1 && right != -1) {
                answer = new int[]{left, right};
                return;
            }
        }
        
    }
    
    public int[] solution(int[] sequence, int k) {
        sum = new int[sequence.length + 1];
        for(int idx = 1; idx <= sequence.length; idx++) {
            sum[idx] = sum[idx - 1] + sequence[idx - 1];
        }
        
        solve(sequence, k);
        
        return answer;
    }
}