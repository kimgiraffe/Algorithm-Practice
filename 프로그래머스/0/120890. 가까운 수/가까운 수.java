import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = 100;
        
        Arrays.sort(array);
        
        for (int i = 0; i < array.length; i++) {
            int diff = n - array[i];
            if (diff < 0) {
                diff *= -1;
            }
            
            if (min > diff) {
                min = diff;
                
                answer = array[i];
            }
        }
        
        return answer;
    }
}