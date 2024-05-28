import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 차이를_최대로
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static int N;
  static int[] A;
  static boolean[] visited;
  static int[] selected;
  static int max;

  static void permutation(int curIdx) {
    if (curIdx == N) {
      int sum = 0;
      for (int idx = 1; idx < N; idx++) {
        sum += Math.abs(selected[idx] - selected[idx - 1]);
      }
      max = Math.max(max, sum);
      return;
    }

    for (int idx = 0; idx < N; idx++) {
      if (visited[idx]) {
        continue;
      }

      visited[idx] = true;
      selected[curIdx] = A[idx];
      permutation(curIdx + 1);
      visited[idx] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine().trim());
    A = new int[N];
    visited = new boolean[N];
    selected = new int[N];

    st = new StringTokenizer(br.readLine().trim());
    for (int idx = 0; idx < N; idx++) {
      A[idx] = Integer.parseInt(st.nextToken());
    }

    permutation(0);
    System.out.println(max);
  }
}