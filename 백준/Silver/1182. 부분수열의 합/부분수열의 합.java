import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분수열의_합
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int n, s;
  static int[] nums;
  static int count;
  static boolean[] selected;

  static void powerSet(int selectIdx) {
    if (selectIdx == n) {
      int sum = 0;
      int cnt = 0;
      for (int idx = 0; idx < n; idx++) {
        if (selected[idx]) {
          sum += nums[idx];
          cnt++;
        }
      }
      if (sum == s && cnt != 0) {
        count++;
      }
      return;
    }

    selected[selectIdx] = true;
    powerSet(selectIdx + 1);

    selected[selectIdx] = false;
    powerSet(selectIdx + 1);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    nums = new int[n];
    selected = new boolean[n];

    st = new StringTokenizer(br.readLine().trim());
    for (int idx = 0; idx < n; idx++) {
      nums[idx] = Integer.parseInt(st.nextToken());
    }

    powerSet(0);

    System.out.println(count);
  }
}