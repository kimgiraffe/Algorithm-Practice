/**
 * 
 *
 */

class Solution {
    static StringBuilder sb;
    static String answer = "";
    
    static void solve(int n, int t, int m, int p) {
        int num = 0;
        while(sb.length() < m * t) {
            sb.append(Integer.toString(num++, n));
        }
        
        for(int i = p - 1; i < m * t; i += m) {
            answer += sb.charAt(i);
        }
        
    }
    public String solution(int n, int t, int m, int p) {
        sb = new StringBuilder();
        solve(n, t, m, p);
        
        return answer.toUpperCase();
    }
}