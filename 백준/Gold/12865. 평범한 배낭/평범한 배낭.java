import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int N, K; // 물품의 수, 버틸 수 있는 무게
  static int[] weight; // 물건의 무게
  static int[] value; // 물건의 가치
  static int[] dp; // dp[i] : 무게가 정확히 i가 되는 경우의 최댓값

  public static void solve() {
    for (int i = 0; i < N; i++) {
      for (int j = K; j >= weight[i]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
      }
    }

    System.out.println(dp[K]);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    weight = new int[N];
    value = new int[N];
    dp = new int[K + 1];

    for (int idx = 0; idx < N; idx++) {
      st = new StringTokenizer(br.readLine().trim());
      weight[idx] = Integer.parseInt(st.nextToken());
      value[idx] = Integer.parseInt(st.nextToken());
    }

    solve();

  }
}