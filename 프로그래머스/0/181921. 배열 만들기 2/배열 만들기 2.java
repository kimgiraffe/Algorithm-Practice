import java.util.*;

class Solution {
    static List<Integer> list;
    
    static boolean check(int num) {
        while (num > 0) {
            if(num % 10 != 0 && num % 10 != 5) {
                return false;
            }
            num /= 10;
        }
        
        return true;
    }
    
    public int[] solution(int l, int r) {
        list = new ArrayList<>();
        
        for (int n = l; n <= r; n++) {
            if(check(n)) {
                list.add(n);
            }
        }
        
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();
    }
}