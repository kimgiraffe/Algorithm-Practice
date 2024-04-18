import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 입국심사
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static long N, M;
  static long[] T;
  static long low, mid, high;

  static boolean decide() {
    long people = 0;
    for (int idx = 0; idx < N; idx++) {
      people += mid / T[idx];
      if (people >= M) {
        return false;
      }
    }

    return people < M;
  }

  static void lowerBound() {
    low = T[0];
    high = T[(int) N - 1] * M;

    while (low <= high) {
      mid = low + (high - low) / 2;

      if (decide()) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    System.out.println(low);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    N = Long.parseLong(st.nextToken());
    M = Long.parseLong(st.nextToken());

    T = new long[(int) N];

    for (int idx = 0; idx < N; idx++) {
      T[idx] = Long.parseLong(br.readLine().trim());
    }

    Arrays.sort(T);

    lowerBound();
  }
}