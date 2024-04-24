import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 소_난다
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int N, M;
  static int[] h;
  static int[] selected;
  static int[] sum;
  static Map<Integer, Integer> map;

  static void combination(int selectIdx, int curIdx) {
    if (selectIdx == M) {
      int sum = 0;
      for (int idx = 0; idx < M; idx++) {
        sum += selected[idx];
      }
      for (int num = 2; num * num <= sum; num++) {
        if (sum % num == 0) {
          return;
        }
      }
      map.put(sum, map.getOrDefault(sum, 1));
      return;
    }

    if (curIdx == N) {
      return;
    }

    selected[selectIdx] = h[curIdx];
    combination(selectIdx + 1, curIdx + 1);

    combination(selectIdx, curIdx + 1);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());
    sb = new StringBuilder();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    h = new int[N];
    selected = new int[M];
    map = new HashMap<>();

    st = new StringTokenizer(br.readLine().trim());
    for (int idx = 0; idx < N; idx++) {
      h[idx] = Integer.parseInt(st.nextToken());
    }

    combination(0, 0);

    if (map.size() == 0) {
      System.out.println(-1);
      return;
    }

    sum = new int[map.size()];

    int idx = 0;
    for (int num : map.keySet()) {
      sum[idx++] = num;
    }

    Arrays.sort(sum);

    for (int i = 0; i < idx; i++) {
      sb.append(sum[i]).append(" ");
    }

    System.out.println(sb);
  }
}