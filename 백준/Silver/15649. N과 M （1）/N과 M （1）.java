import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과_M_1
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int N, M;
  static int[] selected;
  static boolean[] visited;

  static void permutation(int curIdx) {
    if (curIdx == M) {
      for (int idx = 0; idx < M; idx++) {
        sb.append(selected[idx]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int idx = 0; idx < N; idx++) {
      if (visited[idx])
        continue;

      visited[idx] = true;
      selected[curIdx] = idx + 1;
      permutation(curIdx + 1);
      visited[idx] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    sb = new StringBuilder();
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    selected = new int[M];
    visited = new boolean[N];

    permutation(0);

    System.out.print(sb);
  }
}