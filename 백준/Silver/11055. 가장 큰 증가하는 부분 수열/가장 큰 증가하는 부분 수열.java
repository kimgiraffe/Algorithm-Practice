import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 가장_큰_증가하는_부분_수열
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static int N;
  static int[] arr;
  static int[] dp;
  static int answer;

  public static void solve() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i]);
        }
      }
      answer = Math.max(answer, dp[i]);
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine().trim());
    arr = new int[N];
    dp = new int[N];

    st = new StringTokenizer(br.readLine().trim());
    for (int idx = 0; idx < N; idx++) {
      arr[idx] = Integer.parseInt(st.nextToken());
      dp[idx] = arr[idx];
    }

    solve();

    System.out.println(answer);
  }
}