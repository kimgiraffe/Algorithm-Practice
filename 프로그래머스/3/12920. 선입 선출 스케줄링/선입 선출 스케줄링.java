class Solution {
    public int binarySearch(int n, int[] cores) {
        int answer = 0;
        int lo = 0;
        int hi = 10000 * n;
        int work = 0;
        int time = 0;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = calculate(mid, cores);
            
            if(count >= n) {
                hi = mid - 1;
                time = mid;
                work = count;
            } else {
                lo = mid + 1;
            }
        }
        
        work -= n;
        for(int idx = cores.length - 1; idx >= 0; idx--) {
            if(time % cores[idx] == 0) {
                if(work == 0) {
                    answer = idx + 1;
                    break;
                }
                work--;
            }
        }
        
        return answer;
    }
    
    public int calculate(int time, int[] cores) {
        int count = cores.length;
        
        for(int idx = 0; idx < cores.length; idx++) {
            count += (time / cores[idx]);
        }
        
        return count;
    }
    
    public int solution(int n, int[] cores) {
        return binarySearch(n, cores);
    }
}