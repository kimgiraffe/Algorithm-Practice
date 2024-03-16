import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int N; // 좌표의 개수
  static int[] coordinate;
  static int[] copied;
  static HashMap<Integer, Integer> hashMap = new HashMap<>();

  static void solve() {
    int rank = 0;
    for (int v : copied) {
      if (!hashMap.containsKey(v)) {
        hashMap.put(v, rank++);
      }
    }

    for (int k : coordinate) {
      sb.append(hashMap.get(k)).append(" ");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    N = Integer.parseInt(br.readLine().trim());

    coordinate = new int[N];
    copied = new int[N];
    st = new StringTokenizer(br.readLine().trim());

    for (int idx = 0; idx < N; idx++) {
      copied[idx] = coordinate[idx] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(copied);

    solve();

  }
}