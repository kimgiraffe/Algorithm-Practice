import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 설탕_배달_2
 */
public class Main {
  static BufferedReader br;
  static long N;
  static int answer;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    N = Long.parseLong(br.readLine().trim());

    while (N % 5 != 0) {
      N -= 3;
      answer++;
    }

    if (N < 0) {
      System.out.println(-1);
    } else {
      System.out.println(answer + N / 5);
    }
  }
}