import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 우주신과의_교감
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int N, M; // 우주선의 개수, 이미 연결된 통로의 개수
  static double answer;

  static class Point {
    double x;
    double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Edge implements Comparable<Edge> {
    int from;
    int to;
    double weight;

    public Edge(int from, int to, double weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      if (this.weight > o.weight) {
        return 1;
      } else {
        return -1;
      }
    }

    @Override
    public String toString() {
      return this.from + " " + this.to + " " + this.weight;
    }
  }

  static Point[] points;
  static List<Edge> edges;
  static int[] parent;

  static void make() {
    parent = new int[N + 1];
    for (int idx = 0; idx <= N; idx++) {
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

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    points = new Point[N + 1];
    edges = new ArrayList<>();
    make();

    for (int idx = 1; idx <= N; idx++) {
      st = new StringTokenizer(br.readLine().trim());
      double x = Double.parseDouble(st.nextToken());
      double y = Double.parseDouble(st.nextToken());
      points[idx] = new Point(x, y);
    }

    for (int idx = 0; idx < M; idx++) {
      st = new StringTokenizer(br.readLine().trim());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      union(from, to);
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (i == j)
          continue;
        double weight = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
        edges.add(new Edge(i, j, weight));
      }
    }

    Collections.sort(edges);

    for (Edge edge : edges) {
      if (union(edge.from, edge.to)) {
        answer += edge.weight;
      }
    }

    System.out.printf("%.2f", answer);
  }
}