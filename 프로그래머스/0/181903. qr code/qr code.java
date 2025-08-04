class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        
        for (int idx = r; idx < code.length(); idx += q) {
            answer += code.charAt(idx);
        }
        
        return answer;
    }
}