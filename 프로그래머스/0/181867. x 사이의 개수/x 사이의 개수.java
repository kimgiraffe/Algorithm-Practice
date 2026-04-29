class Solution {
    public int[] solution(String myString) {
        String[] str = myString.split("x", -1);
        int[] answer = new int[str.length];
        
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = str[idx].length();
        }
        
        return answer;
    }
}