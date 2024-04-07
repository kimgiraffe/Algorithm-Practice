class Solution {
    static int[][] dp;
    static int answer;
    
    static void solve(int[][] land) {
        for(int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                if(j == 0) {
                    dp[i][j] = land[i][j] + Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i -1][3]));
                } else if(j == 1) {
                    dp[i][j] = land[i][j] + Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i -1][3]));
                } else if(j == 2) {
                    dp[i][j] = land[i][j] + Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i -1][3]));
                } else if(j == 3) {
                    dp[i][j] = land[i][j] + Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i -1][2]));
                }
            }
        }
        
        answer = Math.max((Math.max(dp[land.length - 1][0], dp[land.length - 1][1])), (Math.max(dp[land.length - 1][2], dp[land.length - 1][3])));
    }
    
    int solution(int[][] land) {
        dp = new int[land.length][4];
        
        solve(land);

        return answer;
    }
}