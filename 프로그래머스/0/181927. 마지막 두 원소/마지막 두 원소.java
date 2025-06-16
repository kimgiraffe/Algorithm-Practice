class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len + 1];
        
        for (int idx = 0; idx < len; idx++) {
            answer[idx] = num_list[idx];
        }
        
        if (num_list[len - 1] > num_list[len - 2]) {
            answer[len] = num_list[len - 1] - num_list[len - 2];
        } else {
            answer[len] = num_list[len - 1] << 1;
        }
        
        return answer;
    }
}