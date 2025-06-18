class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int mid = (int)Math.ceil((double)total / num);
        
        int lo = mid - num / 2;
        
        
        for (int idx = 0; idx < num; idx++) {
            answer[idx] = lo++;
        }
        
        return answer;
    }
}