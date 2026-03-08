class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        
        for (int idx = 0; idx < strArr.length; idx++) {
            if(idx % 2 == 1) {
                answer[idx] = strArr[idx].toUpperCase();
            } else {
                answer[idx] = strArr[idx].toLowerCase();
            }
        }
        
        return answer;
    }
}