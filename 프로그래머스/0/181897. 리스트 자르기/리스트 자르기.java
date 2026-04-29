import java.util.*;

class Solution {
    static List<Integer> list;
    
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        list = new ArrayList<>();
        
        int start = slicer[0];
        int end = slicer[1];
        int step = slicer[2];
        
        if (n == 1) {
            answer = new int[end + 1];
            for (int idx = 0; idx <= end; idx++) {
                answer[idx] = num_list[idx];
            }
        } else if (n == 2) {
            answer = new int[num_list.length - start];
            for (int idx = 0; idx < num_list.length - start; idx++) {
                answer[idx] = num_list[idx + start];
            }
        } else if (n == 3) {
            answer = new int[end - start + 1];
            for (int idx = 0; idx <= end - start; idx++) {
                answer[idx] = num_list[idx + start];
            }
        } else {
            int i = 0;
            answer = new int[(end - start) / step + 1];
            for (int idx = 0; idx < (end - start) / step + 1; idx++) {
                answer[i++] = num_list[idx * step + start];
            }
        }
        
        return answer;
    }
}