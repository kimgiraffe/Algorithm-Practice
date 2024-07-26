class Solution {
    int[][] distance;
    final int INF = 100000;

    public void floyd(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (distance[j][i] != INF && distance[i][k] != INF) {
                        distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                    }
                }
            }
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        distance = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = INF;
            }
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            if (distance[from][to] > weight) {
                distance[from][to] = weight;
            }

            if (distance[to][from] > weight) {
                distance[to][from] = weight;
            }
        }

        floyd(n);

        int min = INF;

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count < min) {
                min = count;
                answer = i;
            }
        }

        return answer;
    }
}