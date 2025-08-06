import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int start = -1;
        int end = -1;
        
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] == 2) {
                if (start == -1) {
                    start = idx;
                }
                end = idx;
            }
        }
        
        if (start == -1) {
            return new int[]{-1};
        }
        
        return Arrays.copyOfRange(arr, start, end + 1);
    }
}