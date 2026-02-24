class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] check = new int[201];
        

        for (int j = 0; j < lines.length; j++) {
            int start = lines[j][0] + 100;
            int end = lines[j][1] + 100;
            for (int k = start; k < end; k++) {
                if(check[k] ==1) {
                    answer++;
                }
                check[k]++;
            }
        }
        
        return answer;
    }
}