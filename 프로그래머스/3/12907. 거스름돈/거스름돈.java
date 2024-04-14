class Solution {
    static int[] dp;
    static final int MOD = 1000000007;
    
    public int solution(int n, int[] money) {
        int answer = 0;
        dp = new int[n + 1];
        dp[0] = 1;
        
        for(int idx = 0; idx < money.length; idx++) {
            for(int j = money[idx]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - money[idx]] ) % MOD;
            }
        }
        
        return dp[n] % MOD;
    }
}