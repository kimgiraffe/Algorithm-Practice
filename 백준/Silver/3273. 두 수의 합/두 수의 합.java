import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두_수의_합
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static int n, x;
  static int[] arr;
  static int count;

  static void solve() {
    int low = 0;
    int high = n - 1;

    while (low < high) {
      int sum = arr[low] + arr[high];

      if (sum == x) {
        count++;
        low++;
        high--;
      } else if (sum < x) {
        low++;
      } else {
        high--;
      }

    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine().trim());

    arr = new int[n];
    st = new StringTokenizer(br.readLine().trim());
    for (int idx = 0; idx < n; idx++) {
      arr[idx] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    x = Integer.parseInt(br.readLine().trim());

    solve();
    System.out.println(count);
  }
}