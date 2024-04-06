import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과_M_11
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int n, m;
  static int[] nums;
  static int[] selected;

  static void combination(int selectIdx) {
    if (selectIdx == m) {
      for (int idx = 0; idx < m; idx++) {
        sb.append(selected[idx]).append(" ");
      }
      sb.append("\n");
      return;
    }

    int before = -1;
    for (int idx = 0; idx < n; idx++) {
      if (nums[idx] != before) {
        before = nums[idx];
        selected[selectIdx] = nums[idx];
        combination(selectIdx + 1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());
    sb = new StringBuilder();

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    nums = new int[n];
    selected = new int[m];

    st = new StringTokenizer(br.readLine().trim());
    for (int idx = 0; idx < n; idx++) {
      nums[idx] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(nums);

    combination(0);
    System.out.print(sb);
  }
}