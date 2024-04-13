import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주식
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int T;
  static int n;
  static int[] p;
  static long max;

  static void solve() {
    max = 0;
    int j = n - 1;
    for (int idx = n - 2; idx >= 0; idx--) {
      if (p[idx] < p[j]) {
        max += p[j] - p[idx];
      } else {
        j = idx;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 수 입력

    while (T-- > 0) {
      n = Integer.parseInt(br.readLine().trim()); // 날의 수 입력
      p = new int[n];
      st = new StringTokenizer(br.readLine().trim());
      for (int idx = 0; idx < n; idx++) {
        p[idx] = Integer.parseInt(st.nextToken());
      }

      solve();

      sb.append(max).append("\n");
    }

    System.out.print(sb);
  }
}