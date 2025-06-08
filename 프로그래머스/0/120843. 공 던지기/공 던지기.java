class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int n = numbers.length;
        
        answer = numbers[(k - 1) * 2 % n];
        
        return answer;
    }
}