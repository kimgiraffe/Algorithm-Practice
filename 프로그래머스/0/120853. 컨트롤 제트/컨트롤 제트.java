class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split(" ");
        
        for (int idx = 0; idx < str.length; idx++) {
            if(str[idx].equals("Z")) {
                answer -= Integer.parseInt(str[idx - 1]);
            } else {
                answer += Integer.parseInt(str[idx]);
            }
        }
        
        return answer;
    }
}