import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최소_스패닝_트리
 */
public class Main {

  static BufferedReader br;
  static StringTokenizer st;

  static int V, E;

  static int[] parent;
  static Edge[] edges;
  static int answer, count;

  static class Edge implements Comparable<Edge> {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.weight, o.weight);
    }
  }

  static void make() {
    for (int idx = 0; idx <= V; idx++) {
      parent[idx] = idx;
    }
  }

  static int find(int a) {
    if (parent[a] == a) {
      return a;
    }

    return parent[a] = find(parent[a]);
  }

  static boolean union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);

    if (aRoot == bRoot) {
      return false;
    }
    parent[bRoot] = aRoot;
    return true;
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    parent = new int[V + 1];
    edges = new Edge[E];

    for (int idx = 0; idx < E; idx++) {
      st = new StringTokenizer(br.readLine().trim());

      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      edges[idx] = new Edge(from, to, weight);
    }

    Arrays.sort(edges);

    make();

    for (Edge edge : edges) {
      if (union(edge.from, edge.to)) {
        answer += edge.weight;
        if (++count == V - 1)
          break;
      }
    }

    System.out.println(answer);

  }
}