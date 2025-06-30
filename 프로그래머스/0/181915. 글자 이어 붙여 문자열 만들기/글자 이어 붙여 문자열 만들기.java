class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        
        for (int idx = 0; idx < index_list.length; idx++) {
            answer += my_string.charAt(index_list[idx]);
        }
        
        return answer;
    }
}