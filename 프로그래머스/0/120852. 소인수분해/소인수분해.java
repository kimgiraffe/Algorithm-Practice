import java.util.*;

class Solution {
    static Set<Integer> set;
    
    public int[] solution(int n) {
        set = new HashSet<>();
        int d = 2;
        
        while (n > 1) {
            if (n % d == 0) {
                set.add(d);
                n /= d;
            } else {
                d++;
            }
        }
        
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        
        Arrays.sort(answer);
        
        return answer;
    }
}