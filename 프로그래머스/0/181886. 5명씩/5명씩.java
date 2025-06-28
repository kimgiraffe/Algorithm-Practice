class Solution {
    static int size, i;
    
    public String[] solution(String[] names) {
        if (names.length % 5 == 0) {
            size = names.length / 5;
        } else {
            size = names.length / 5 + 1;    
        }
        
        String[] answer = new String[size];
        
        for (int idx = 0; idx < names.length; idx+=5) {
            answer[i++] = names[idx];
        }
        
        return answer;
    }
}