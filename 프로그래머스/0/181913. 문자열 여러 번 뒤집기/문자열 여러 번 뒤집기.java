class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        
        for (int idx = 0; idx < queries.length; idx++) {
            int s = queries[idx][0];
            int e = queries[idx][1];
            
            while (s < e) {
                char tmp = sb.charAt(s);
                sb.setCharAt(s, sb.charAt(e));
                sb.setCharAt(e, tmp);
                s++;
                e--;
            }
        }
        
        return sb.toString();
    }
}