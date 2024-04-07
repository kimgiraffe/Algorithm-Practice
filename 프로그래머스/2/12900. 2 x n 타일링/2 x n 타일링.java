class Solution {
    static int[] dp;
    static final int MOD = 1000000007;
    
    static void solve(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for(int idx = 3; idx <= n; idx++) {
            dp[idx] = (dp[idx - 1] + dp[idx - 2]) % MOD;
        }
    }
    
    public int solution(int n) {
        dp = new int[n + 1];
        solve(n);
        int answer = dp[n];        
        return answer;
    }
}