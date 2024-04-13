import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 전깃줄
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int n; // 전깃줄의 개수
  static int cnt;

  static class Line implements Comparable<Line> {
    int s;
    int e;

    public Line(int s, int e) {
      this.s = s;
      this.e = e;
    }

    @Override
    public int compareTo(Line o) {
      return this.s - o.s;
    }
  }

  static Line[] lines;
  static int[] dp;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine().trim());

    lines = new Line[n];
    dp = new int[n];

    for (int idx = 0; idx < n; idx++) {
      st = new StringTokenizer(br.readLine().trim());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      lines[idx] = new Line(s, e);
    }

    Arrays.sort(lines);

    for (int idx = 0; idx < n; idx++) {
      dp[idx] = 1;
      for (int j = 0; j < idx; j++) {
        if (lines[idx].e > lines[j].e) {
          dp[idx] = Math.max(dp[idx], dp[j] + 1);
        }
      }
      cnt = Math.max(cnt, dp[idx]);
    }

    System.out.println(n - cnt);
  }
}