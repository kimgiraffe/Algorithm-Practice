import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();
        
        Arrays.sort(b);
        Arrays.sort(a);
        
        int answer = 0;
        return Arrays.equals(a, b) ? 1 : 0;
    }
}