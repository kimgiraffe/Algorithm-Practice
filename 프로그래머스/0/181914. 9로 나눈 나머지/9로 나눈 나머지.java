class Solution {
    public int solution(String number) {
        int answer = 0;
        
        for (int idx = 0; idx < number.length(); idx++) {
            answer += number.charAt(idx) - '0';
        }
        
        return answer % 9;
    }
}