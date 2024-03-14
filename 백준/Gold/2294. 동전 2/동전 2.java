import java.io.*;
import java.util.*;

/**
 * Main
 */
public class Main {

  static BufferedReader br;
  static StringTokenizer st;

  static int n, k; // 동전 종류, 가치의 합
  static int[] coin;
  static int[] dp;
  static final int INF = 987654321;

  static void solve() {
    for (int idx = 1; idx <= n; idx++) {
      for (int j = coin[idx]; j <= k; j++) {
        dp[j] = Math.min(dp[j], dp[j - coin[idx]] + 1);
      }
    }

    if (dp[k] == INF) {
      System.out.println(-1);
    } else {
      System.out.println(dp[k]);
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    coin = new int[n + 1];
    dp = new int[100001];

    for (int idx = 1; idx <= n; idx++) {
      coin[idx] = Integer.parseInt(br.readLine().trim());
    }

    for (int idx = 1; idx <= k; idx++) {
      dp[idx] = INF;
    }

    for (int idx = 1; idx <= n; idx++) {
      dp[coin[idx]] = 1;
    }

    solve();
  }
}