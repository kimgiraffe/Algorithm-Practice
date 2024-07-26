class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        
        for(int idx = 0; idx < numbers.length; idx++) {
            answer[idx]++;
            answer[idx] += (answer[idx] ^ numbers[idx]) >> 2;
        }
        
        return answer;
    }
}