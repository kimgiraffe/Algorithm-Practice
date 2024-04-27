import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 집합의_표현
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int n, m;

  static int[] parent;

  static void make() {
    for (int idx = 0; idx <= n; idx++) {
      parent[idx] = idx;
    }
  }

  static int find(int a) {
    if (a == parent[a]) {
      return a;
    }
    return parent[a] = find(parent[a]);
  }

  static void union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);

    if (aRoot == bRoot)
      return;

    if (aRoot < bRoot) {
      parent[bRoot] = aRoot;
    } else {
      parent[aRoot] = bRoot;
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());
    sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    parent = new int[n + 1];
    make();

    for (int idx = 0; idx < m; idx++) {
      st = new StringTokenizer(br.readLine().trim());
      int mode = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (mode == 0) {
        union(a, b);
      } else if (mode == 1) {
        if (find(a) == find(b)) {
          sb.append("YES").append("\n");
        } else {
          sb.append("NO").append("\n");
        }
      }
    }

    System.out.print(sb);
  }
}