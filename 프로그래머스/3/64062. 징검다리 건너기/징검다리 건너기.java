import java.util.*;

class Solution {
    boolean isPossible(int[] stones, int k, int d) {
        int count = 0;
        for(int idx = 0; idx < stones.length; idx++) {
            if(stones[idx] <= d) {
                count++;
                if(count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        
        return true;
    }
    
    public int solution(int[] stones, int k) {
        int answer = 0;
        int n = stones.length;
        int[] copy = stones.clone();
        Arrays.sort(copy);
        int lo = 1;
        int hi = copy[n - 1];
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(isPossible(stones, k, mid)) {
                lo = mid + 1;
                answer = lo;
            } else {
                hi = mid - 1;
            }
        }
        
        return answer;
    }
}