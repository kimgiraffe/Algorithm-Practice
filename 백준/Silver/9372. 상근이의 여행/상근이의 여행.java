import java.io.*;
import java.util.*;

/**
 * 상근이의_여행
 */
public class Main {

  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int T; // 테스트케이스 수
  static int N; // 국가의 수
  static int M; // 비행기의 종류

  static class Node {
    int from;
    int to;

    public Node(int from, int to) {
      this.from = from;
      this.to = to;
    }
  }

  static Node[] nodes;
  static int[] parent;

  static void make(int n) {
    parent = new int[n + 1];
    for (int idx = 0; idx <= n; idx++) {
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
    sb = new StringBuilder();
    T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine().trim());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      nodes = new Node[M];
      make(N);
      int count = 0;
      int result = 0;

      for (int idx = 0; idx < M; idx++) {
        st = new StringTokenizer(br.readLine().trim());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        nodes[idx] = new Node(a, b);

      }
      for (Node node : nodes) {
        if (union(node.from, node.to)) {
          result++;
          if (++count == N - 1) {
            break;
          }
        }
      }
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }
}