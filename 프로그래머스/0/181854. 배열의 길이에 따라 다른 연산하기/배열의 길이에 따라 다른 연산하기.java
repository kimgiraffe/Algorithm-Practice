class Solution {
    static int[] answer;
    
    public int[] solution(int[] arr, int n) {
        int length = arr.length;
        answer = arr;
        
        if(length % 2 == 1) {           
            for (int i = 0; i < length; i += 2) {
                answer[i] += n;
            }
        } else {
            for (int i = 1; i < length; i += 2) {
                answer[i] += n;
            }
        }
        
        return answer;
    }
}