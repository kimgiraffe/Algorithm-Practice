import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리의_지름
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int n; // 노드의 개수
  static int answer = Integer.MIN_VALUE; // 트리의 지름
  static int maxNode;

  static class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  static List<Node>[] nodes;
  static boolean[] visited;

  static void dfs(int cur, int sum) {
    visited[cur] = true;

    if (sum > answer) {
      answer = sum;
      maxNode = cur;
    }

    for (Node node : nodes[cur]) {
      if (!visited[node.to]) {
        dfs(node.to, sum + node.weight);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine().trim());
    nodes = new ArrayList[n + 1];
    for (int idx = 0; idx <= n; idx++) {
      nodes[idx] = new ArrayList<>();
    }
    visited = new boolean[n + 1];

    for (int idx = 1; idx < n; idx++) {
      st = new StringTokenizer(br.readLine().trim());

      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      nodes[from].add(new Node(to, weight));
      nodes[to].add(new Node(from, weight));
    }

    dfs(1, 0);
    visited = new boolean[n + 1];
    answer = Integer.MIN_VALUE;
    dfs(maxNode, 0);

    System.out.println(answer);
  }
}