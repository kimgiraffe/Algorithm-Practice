class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] str = my_string.split(" ");
        answer = Integer.parseInt(str[0]);
        
        for (int idx = 1; idx < str.length; idx++) {
            int num = 0;
            if (idx % 2 != 0) {
                if(str[idx].equals("+")) {
                    answer += Integer.parseInt(str[idx + 1]);
                } else {
                    answer -= Integer.parseInt(str[idx + 1]);
                }
            }
        }
        
        return answer;
    }
}