import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 극장_좌석
 */
public class Main {
  static BufferedReader br;
  static int N; // 좌석의 개수
  static int M; // 고정석의 개수
  static int[] dp;
  static int[] vip;
  static int answer = 1;

  static void solve() {
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int idx = 3; idx <= N; idx++) {
      dp[idx] = dp[idx - 1] + dp[idx - 2];
    }

    int start = 0;
    for (int idx = 0; idx < M; idx++) {
      int end = vip[idx];
      answer *= dp[end - start - 1];
      start = end;
    }

    answer *= dp[N - start];
    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine().trim());
    M = Integer.parseInt(br.readLine().trim());

    dp = new int[41];
    vip = new int[41];
    for (int idx = 0; idx < M; idx++) {
      vip[idx] = Integer.parseInt(br.readLine().trim());
    }

    solve();
  }
}