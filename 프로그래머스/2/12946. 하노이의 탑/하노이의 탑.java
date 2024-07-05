class Solution {
    static int idx;
    static int[][] answer;
    
    static void hanoi(int n, int from, int by, int to) {
        if(n == 1) {
            move(1, from, to);
        } else {
            hanoi(n - 1, from, to, by);
            move(n, from, to);
            hanoi(n - 1, by, from, to);
        }
    }
    
    static void move(int n, int from, int to) {
        answer[idx][0] = from;
        answer[idx][1] = to;
        idx++;
    }
    
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2, n) - 1][2];
        hanoi(n, 1, 2, 3);
        
        return answer;
    }
}