import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 카드_놓기
 */
public class Main {
  static BufferedReader br;
  static int n, k;
  static String[] cards;
  static Map<String, Integer> map;
  static boolean[] visited;

  static void dfs(int depth, String tmp) {
    if (depth == k) {
      map.put(tmp, 1);
      return;
    }

    for (int idx = 0; idx < n; idx++) {
      if (visited[idx])
        continue;
      visited[idx] = true;

      dfs(depth + 1, tmp + cards[idx]);
      visited[idx] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine().trim());
    k = Integer.parseInt(br.readLine().trim());

    cards = new String[n];
    visited = new boolean[n];

    for (int idx = 0; idx < n; idx++) {
      cards[idx] = br.readLine().trim();
    }

    map = new HashMap<>();

    dfs(0, "");
    System.out.println(map.size());
  }
}