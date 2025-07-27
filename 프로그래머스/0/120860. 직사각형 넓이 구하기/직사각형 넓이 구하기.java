class Solution {
    public int solution(int[][] dots) {
        int w = 0;
        int h = 0;
        
        w = Math.max(Math.abs(dots[1][0] - dots[0][0]), Math.abs(dots[2][0] - dots[1][0]));
        h = Math.max(Math.abs(dots[0][1] - dots[1][1]), Math.abs(dots[2][1] - dots[1][1]));
        
        return w * h;
    }
}