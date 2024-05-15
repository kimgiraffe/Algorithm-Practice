import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문자열_집합
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static int N, M;
  static Map<String, Integer> map;
  static int count;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    map = new HashMap<>();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int idx = 0; idx < N; idx++) {
      map.put(br.readLine().trim(), 1);
    }

    for (int idx = 0; idx < M; idx++) {
      if (map.containsKey(br.readLine().trim())) {
        count++;
      }
    }

    System.out.println(count);
  }
}