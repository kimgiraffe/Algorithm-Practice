import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int cityCount; // 도시의 개수
  static int busCount; // 버스의 개수

  static int[][] cost;

  static void floyd() {
    for (int i = 1; i <= cityCount; i++) {
      for (int j = 1; j <= cityCount; j++) {
        for (int k = 1; k <= cityCount; k++) {
          if (cost[j][i] != Integer.MAX_VALUE && cost[i][k] != Integer.MAX_VALUE) {
            cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
          }
        }
      }
    }
  }

  static void print() {
    for (int i = 1; i <= cityCount; i++) {
      for (int j = 1; j <= cityCount; j++) {
        if (i == j || cost[i][j] == Integer.MAX_VALUE) {
          sb.append(0).append(" ");
        } else {
          sb.append(cost[i][j]).append(" ");
        }
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    cityCount = Integer.parseInt(br.readLine().trim());
    busCount = Integer.parseInt(br.readLine().trim());

    cost = new int[cityCount + 1][cityCount + 1];

    for (int i = 1; i <= cityCount; i++) {
      for (int j = 1; j <= cityCount; j++) {
        cost[i][j] = Integer.MAX_VALUE;
      }
    }

    for (int idx = 0; idx < busCount; idx++) {
      st = new StringTokenizer(br.readLine().trim());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      if (cost[start][end] > c) {
        cost[start][end] = c;
      }
    }

    floyd();
    print();
  }

}