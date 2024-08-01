import java.util.*;

class Solution {
    static int answer;
    static int coreSize;
    
    public int process(int m, int[] cores) {
        int count = coreSize;
        for(int i = 0; i < coreSize; i++) {
            count += (m / cores[i]);
        }
        
        return count;
    }
    
    public int binarySearch(int n, int[] cores) {
        int lo = 1;
        int hi = 50000;
        int work = 0;
        int time = 0;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = process(mid, cores);
            
            if(count >= n) {
                hi = mid - 1;
                time = mid;
                work = count;
            } else {
                lo = mid + 1;
            }
        }
        
        work -= n;
        for(int i = coreSize - 1; i >= 0; i--) {
            if(time % cores[i] == 0) {
                if(work == 0) {
                    answer = i + 1;
                    break;
                }
                work--;
            }
        }
        
        return answer;
    }
        
    public int solution(int n, int[] cores) {
        coreSize = cores.length;
        
        answer = binarySearch(n, cores);
        
        return answer;
    }
}