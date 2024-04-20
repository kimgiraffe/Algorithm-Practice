import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * HI_ARC
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static int H, I, A, R, C;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());
    H = Integer.parseInt(st.nextToken());
    I = Integer.parseInt(st.nextToken());
    A = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    System.out.println(H * I - A * R * C);
  }
}