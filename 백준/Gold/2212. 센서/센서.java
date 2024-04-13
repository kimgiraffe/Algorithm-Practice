import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 센서
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int N, K;
  static int[] coord;
  static Integer[] diff;
  static int sum;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine().trim());
    K = Integer.parseInt(br.readLine().trim());

    coord = new int[N];
    diff = new Integer[N - 1];
    st = new StringTokenizer(br.readLine().trim());

    for (int idx = 0; idx < N; idx++) {
      coord[idx] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(coord);
    for (int idx = 0; idx < N - 1; idx++) {
      diff[idx] = coord[idx + 1] - coord[idx];
    }

    Arrays.sort(diff, Collections.reverseOrder());

    for (int idx = K - 1; idx < N - 1; idx++) {
      sum += diff[idx];
    }

    System.out.println(sum);

  }
}