import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;
  static int[][] ability;
  static boolean[] visited;
  static int T;
  static int max;

  static void combination(int pos, int sum) {
    if (pos == 11) {
      max = Math.max(max, sum);
      return;
    }

    for (int idx = 0; idx < 11; idx++) {
      if (visited[idx]) // 포지션에 선수를 채운 경우
        continue;
      if (ability[pos][idx] == 0) // 능력치가 0인 포지션에는 배치 불가
        continue;
      visited[idx] = true; // 포지션 배치하고 넘어가기
      combination(pos + 1, sum + ability[pos][idx]);
      visited[idx] = false; // 포지션 배치하지 않고 넘어가기
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    T = Integer.parseInt(br.readLine().trim());

    while (T-- > 0) {
      ability = new int[11][11];
      visited = new boolean[11];
      max = 0;

      for (int row = 0; row < 11; row++) {
        st = new StringTokenizer(br.readLine().trim());
        for (int col = 0; col < 11; col++) {
          ability[row][col] = Integer.parseInt(st.nextToken());
        }
      }

      combination(0, 0);
      sb.append(max).append("\n");
    }

    System.out.println(sb);
  }
}