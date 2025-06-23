class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        
        for (int idx = 0; idx < numLog.length - 1; idx++) {
            if(numLog[idx + 1] - numLog[idx] == 1) {
                answer += "w";
            } else if(numLog[idx + 1] - numLog[idx] == -1) {
                answer += "s";
            } else if(numLog[idx + 1] - numLog[idx] == 10) {
                answer += "d";
            } else if(numLog[idx + 1] - numLog[idx] == -10) {
                answer += "a";
            }
        }
        
        return answer;
    }
}