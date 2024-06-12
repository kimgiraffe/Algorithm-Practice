class Solution {
    static int[][] costs;
    
    static void floyd(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(costs[j][i] != Integer.MAX_VALUE && costs[i][k] != Integer.MAX_VALUE) {
                        if(costs[j][k] == Integer.MAX_VALUE) {
                            costs[j][k] = costs[j][i] + costs[i][k];
                        }
                        else {
                            costs[j][k] = Math.min(costs[j][k], costs[j][i] + costs[i][k]);
                        }
                    }
                }
            }
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        costs = new int[n][n];
        
        for(int from = 0; from < n; from++) {
            for(int to = 0; to < n; to++) {
                costs[from][to] = Integer.MAX_VALUE;
            }
        }
        
        for(int[] fare : fares) {
            costs[fare[0] - 1][fare[1] - 1] = fare[2];
            costs[fare[1] - 1][fare[0] - 1] = fare[2];
        }
        
        floyd(n);
        
        for(int from = 0; from < n; from++) {
            costs[from][from] = 0;
        }
        
        answer = costs[s - 1][a - 1] + costs[s - 1][b - 1];
        
        for(int i = 0; i < n; i++) {
            if(costs[s - 1][i] != Integer.MAX_VALUE && costs[i][a - 1] != Integer.MAX_VALUE && costs[i][b - 1] != Integer.MAX_VALUE) {
                answer = Math.min(answer, costs[s - 1][i] + costs[i][a - 1] + costs[i][b - 1]);
            }
        }
        
        return answer;
    }
}