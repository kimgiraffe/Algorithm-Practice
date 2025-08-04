class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52]; // A(65) -> 0, B -> 1, ... Z -> 25, a(97) -> 26
        
        for (int idx = 0; idx < my_string.length(); idx++) {
            char c = my_string.charAt(idx);
            if (c >= 'A' && c <= 'Z') {
                answer[c - 'A']++;
            } else {
                answer[c - 'a' + 26]++;
            }
        }
        
        return answer;
    }
}