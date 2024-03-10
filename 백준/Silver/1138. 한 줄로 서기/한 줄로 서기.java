import java.io.*;
import java.util.*;

/**
 * BOJ_1138_한줄로서기_김세민
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int N; // 사람의 수
  static int[] arr;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    N = Integer.parseInt(br.readLine().trim());
    arr = new int[N];

    st = new StringTokenizer(br.readLine().trim());
    for (int idx = 0; idx < N; idx++) {
      int left = Integer.parseInt(st.nextToken());
      for (int j = 0; j < N; j++) {
        if (left == 0 && arr[j] == 0) { // 앞에 아무도 없고 빈 자리라면
          arr[j] = idx + 1; // 줄 서기
          break;
        } else if (arr[j] == 0) { // 앞에 사람이 있다면 left가 0이 될 때까지 뒤로 가기
          left--;
        }
      }
    }

    for (int idx = 0; idx < N; idx++) {
      sb.append(arr[idx]).append(" ");
    }

    System.out.println(sb);
  }
}