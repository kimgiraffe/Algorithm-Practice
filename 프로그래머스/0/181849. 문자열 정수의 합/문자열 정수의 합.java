class Solution {
    public int solution(String num_str) {
        int answer = 0;
        
        char[] c = num_str.toCharArray();
        
        for (char ch : c) {
            answer += ch -'0';
        }
        
        return answer;
    }
}