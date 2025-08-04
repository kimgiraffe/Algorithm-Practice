class Solution {
    static int len;
    static char[][] map;

    public String solution(String my_string, int m, int c) {
        len = my_string.length();
        
        String answer = "";
        
        for (int idx = c - 1; idx < len; idx += m) {
            answer += my_string.charAt(idx);
        }
        
        return answer;
    }
}