class Solution {
    public String[] solution(String my_str, int n) {
        int d = my_str.length() / n;
        int len = my_str.length() % n == 0 ? d : d + 1;
        String[] answer = new String[len];
        int i = 0;
        
        for (int idx = 0; idx < my_str.length(); idx += n) {
            int end = Math.min(idx + n, my_str.length());
            answer[i++] = my_str.substring(idx, end);
        }
        
        return answer;
    }
}