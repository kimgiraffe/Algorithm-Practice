class Solution {
    static int cursor; // 현재 커서 위치
    static int move; // 좌우 이동횟수
    public int solution(String name) {
        int answer = 0;
        move = name.length() - 1;
        
        for(int idx = 0; idx < name.length(); idx++) {
            answer += Math.min(name.charAt(idx) - 'A', 'Z' - name.charAt(idx) + 1); // 첫번째 위치에서 조작
            cursor = idx + 1; // 커서 다음 위치로 이동
            
            while(cursor < name.length() && name.charAt(cursor) == 'A') { // 커서를 A가 아닌 곳까지 이동
                cursor++;
            }
            
            move = Math.min(move, idx * 2 + name.length() - cursor); // 오른쪽으로 이동
            move = Math.min(move, (name.length() - cursor) * 2 + idx); // 왼쪽으로 이동
        }
        
        return answer + move;
    }
}