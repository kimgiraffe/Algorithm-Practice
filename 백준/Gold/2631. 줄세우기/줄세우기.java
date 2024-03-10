import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ_2631_줄세우기_김세민
 * 
 * 최장 증가 부분 수열(LIS)
 * 
 * 
 */
public class Main {
  static BufferedReader br;

  static int N; // 아이들의 수
  static int[] child;
  static int[] dp;
  static int max;

  static void solve() {
    for (int idx = 1; idx <= N; idx++) {
      dp[idx] = 1;
      for (int j = 1; j <= idx; j++) {
        if (child[j] < child[idx] && dp[idx] < dp[j] + 1) {
          dp[idx] = dp[j] + 1;
        }
      }
      if (max < dp[idx])
        max = dp[idx];
    }

    System.out.println(N - max); // 전체 어린이 수 - 최장 증가 부분 수열의 길이
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine().trim());
    child = new int[N + 1];
    dp = new int[N + 1];

    for (int idx = 1; idx <= N; idx++) {
      child[idx] = Integer.parseInt(br.readLine().trim());
    }

    solve();
  }
}