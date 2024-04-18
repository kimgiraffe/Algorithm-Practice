import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 숫자고르기
 */
public class Main {
  static BufferedReader br;
  static StringBuilder sb;

  static int N;
  static int[] nums;
  static boolean[] visited;
  static List<Integer> list;

  static void dfs(int start, int num) {
    if (visited[num]) {
      if (start == num) {
        list.add(num);
        sb.append(num).append("\n");
      }
      return;
    }
    visited[num] = true;

    dfs(start, nums[num]);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    N = Integer.parseInt(br.readLine().trim());

    nums = new int[N + 1];
    visited = new boolean[N + 1];
    list = new ArrayList<>();
    for (int idx = 1; idx <= N; idx++) {
      nums[idx] = Integer.parseInt(br.readLine().trim());
    }
    for (int idx = 1; idx <= N; idx++) {
      visited = new boolean[N + 1];

      dfs(idx, idx);
    }

    System.out.println(list.size());
    System.out.print(sb);
  }
}