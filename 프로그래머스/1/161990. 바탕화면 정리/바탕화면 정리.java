class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minRow = 50, maxRow = 0, minCol = 50, maxCol = 0;
        for(int row = 0; row < wallpaper.length; row++) {
            for(int col = 0; col < wallpaper[0].length(); col++) {
                if(wallpaper[row].charAt(col) == '#') {
                    minRow = Math.min(minRow, row);
                    minCol = Math.min(minCol, col);
                    maxRow = Math.max(maxRow, row);
                    maxCol = Math.max(maxCol, col);
                }
            }
        }
        answer[0] = minRow;
        answer[1] = minCol;
        answer[2] = maxRow + 1;
        answer[3] = maxCol + 1;
        
        return answer;
    }
}