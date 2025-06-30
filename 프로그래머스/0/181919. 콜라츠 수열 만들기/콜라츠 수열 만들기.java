import java.util.*;

class Solution {
    static List<Integer> list;
    
    public int[] solution(int n) {
        list = new ArrayList<>();
        
        while (true) {
            list.add(n);
            if (n == 1) {
                break;
            } else if(n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}