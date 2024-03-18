import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int k;
  static int[] number;
  static int[] selected;

  static void combination(int currentIdx, int selectIdx) {
    if (selectIdx == 6) {
      for (int idx = 0; idx < 6; idx++) {
        sb.append(selected[idx]).append(" ");
      }
      sb.append("\n");
      return;
    }

    if (currentIdx == k) {
      return;
    }

    selected[selectIdx] = number[currentIdx];
    combination(currentIdx + 1, selectIdx + 1);

    selected[selectIdx] = 0;
    combination(currentIdx + 1, selectIdx);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    while (true) {
      st = new StringTokenizer(br.readLine().trim());
      k = Integer.parseInt(st.nextToken());
      if (k == 0) {
        break;
      }
      number = new int[k];
      selected = new int[6];

      for (int idx = 0; idx < k; idx++) {
        number[idx] = Integer.parseInt(st.nextToken());
      }

      combination(0, 0);
      sb.append("\n");
    }

    System.out.print(sb);
  }

}