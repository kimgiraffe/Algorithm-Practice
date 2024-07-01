class Solution
{
    public int maxLength(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        
        return end - start - 1;
    }
    
    public int solution(String s)
    {
        int answer = 0;
        
        for(int idx = s.length(); idx >= 0; idx--) {
            answer = Math.max(answer, maxLength(s, idx, idx));
            answer = Math.max(answer, maxLength(s, idx, idx + 1));
        }

        return answer;
    }
}