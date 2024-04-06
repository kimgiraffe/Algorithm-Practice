class Solution {
    public int[] solution(int start, int end_num) {
        int[] answer = new int[start - end_num + 1];
        for(int idx = 0; idx < start - end_num + 1; idx++) {
            answer[idx] = start - idx;
        }
        return answer;
    }
}