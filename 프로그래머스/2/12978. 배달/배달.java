import java.util.*;

class Solution {
    static int[][] cost;
    static int INF = 987654321;
    
    static void floyd(int N, int[][] road) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(cost[j][i] != INF && cost[i][k] != INF) {
                        cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                    }
                }
            }
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        cost = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) {
                    cost[i][j] = 0;
                } else {
                    cost[i][j] = INF;
                }
            }
        }
        
        for(int[] r : road) {
            int from = r[0] - 1;
            int to = r[1] - 1;
            int c = r[2];
            
            cost[from][to] = Math.min(cost[from][to], c);
            cost[to][from] = Math.min(cost[to][from], c);
        }
        
        floyd(N, road);
        
        // System.out.println(Arrays.deepToString(cost));
        
        for(int i = 0; i < N; i++) {
            if(cost[0][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}