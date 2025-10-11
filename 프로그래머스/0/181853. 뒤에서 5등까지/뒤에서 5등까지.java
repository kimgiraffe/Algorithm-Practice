import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        
        Arrays.sort(num_list);
        
        for (int idx = 0; idx < 5; idx++) {
            answer[idx] = num_list[idx];
        }
        
        return answer;
    }
}