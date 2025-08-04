class Solution {
    static StringBuilder sb;
    public String solution(String my_string, int s, int e) {
        sb = new StringBuilder();
        
        sb.append(my_string.substring(0, s));
        String tmp = new StringBuilder(my_string.substring(s, e + 1)).reverse().toString();
        
        sb.append(tmp);
        
        sb.append(my_string.substring(e + 1));
        
        return sb.toString();
    }
}