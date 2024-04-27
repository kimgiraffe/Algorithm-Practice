import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장_가까운_공통_조상
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int T; // 테스트케이스 개수
  static int n; // 노드의 수
  static int[] parent;

  static int countDepth(int node) {
    int depth = 0;
    while (parent[node] != 0) {
      node = parent[node];
      depth++;
    }

    return depth;
  }

  static int LCA(int u, int v) {
    int uDepth = countDepth(u);
    int vDepth = countDepth(v);

    if (uDepth > vDepth) {
      return findCommonParent(u, v, uDepth - vDepth);
    } else {
      return findCommonParent(v, u, vDepth - uDepth);
    }
  }

  static int findCommonParent(int u, int v, int interval) {
    while (interval-- > 0) {
      u = parent[u];
    }

    while (u != v) {
      u = parent[u];
      v = parent[v];
    }

    return u;
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      n = Integer.parseInt(br.readLine().trim()); // 노드의 수 입력
      parent = new int[n + 1];

      for (int idx = 0; idx < n - 1; idx++) {
        st = new StringTokenizer(br.readLine().trim());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        parent[b] = a;
      }

      st = new StringTokenizer(br.readLine().trim());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      sb.append(LCA(u, v)).append("\n");
    }

    System.out.print(sb);
  }
}