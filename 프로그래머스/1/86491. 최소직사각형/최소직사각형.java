class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        
        for(int idx = 0; idx < sizes.length; idx++) {
            w = Math.max(w, Math.max(sizes[idx][0], sizes[idx][1]));
            h = Math.max(h, Math.min(sizes[idx][0], sizes[idx][1]));
        }
        
        return w * h;
    }
}