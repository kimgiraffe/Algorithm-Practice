import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 행성_터널
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static int N; // 행성의 개수
  static int count;

  static class Planet {
    int idx;
    int x;
    int y;
    int z;

    public Planet(int idx, int x, int y, int z) {
      this.idx = idx;
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }

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

  static Planet[] planets;
  static List<Edge> edges;
  static int[] parent;
  static int answer;

  static void make() {
    for (int idx = 0; idx < N; idx++) {
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
    N = Integer.parseInt(br.readLine().trim());

    planets = new Planet[N];
    edges = new ArrayList<>();
    parent = new int[N];

    for (int idx = 0; idx < N; idx++) {
      st = new StringTokenizer(br.readLine().trim());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      planets[idx] = new Planet(idx, x, y, z);
    }

    Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.x, p2.x));
    for (int idx = 1; idx < N; idx++) {
      int weight = Math.abs(planets[idx].x - planets[idx - 1].x);
      edges.add(new Edge(planets[idx].idx, planets[idx - 1].idx, weight));
    }

    Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.y, p2.y));
    for (int idx = 1; idx < N; idx++) {
      int weight = Math.abs(planets[idx].y - planets[idx - 1].y);
      edges.add(new Edge(planets[idx].idx, planets[idx - 1].idx, weight));
    }

    Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.z, p2.z));
    for (int idx = 1; idx < N; idx++) {
      int weight = Math.abs(planets[idx].z - planets[idx - 1].z);
      edges.add(new Edge(planets[idx].idx, planets[idx - 1].idx, weight));
    }

    make();

    Collections.sort(edges);

    for (Edge edge : edges) {
      if (union(edge.from, edge.to)) {
        answer += edge.weight;
        if (++count == N - 1) {
          break;
        }
      }
    }

    System.out.println(answer);
  }
}