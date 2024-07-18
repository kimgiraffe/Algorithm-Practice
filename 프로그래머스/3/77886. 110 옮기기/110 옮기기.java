class Solution {
    static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder _110 = new StringBuilder(); // "110"을 뽑아서 저장
        
        for(int i = 0; i < s.length(); i++) {
            if(sb.length() >= 2 && s.charAt(i) == '0' && sb.charAt(sb.length() - 1) == '1' && sb.charAt(sb.length() - 2) == '1') { // "110" 칮음
                _110.append("110");
                sb.delete(sb.length() - 2, sb.length()); // "110" 뽑기
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        if(_110.length() > 0) {
            if(sb.indexOf("0") == -1) { // "0"이 없는 경우...
                sb.insert(0, _110); // 맨 앞에 110 삽입
            } else { // "0"이 있는 경우...
                // 0이 마지막으로 등장한 위치 다음에 110 삽입
                sb.insert(sb.lastIndexOf("0") + 1, _110);
            }
        }
        
        return sb.toString();
    }
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++) {
            answer[i] = solve(s[i]);
        }
        
        return answer;
    }
}