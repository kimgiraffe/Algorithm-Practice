import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문자_해독
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int w, s;
  static String W, S;
  static int count;

  static int[] wArr = new int[52];
  static int[] sArr = new int[52];

  static void solve() {
    int start = 0;
    int size = 0;

    for (int idx = 0; idx < s; idx++) {
      if ('a' <= S.charAt(idx) && S.charAt(idx) <= 'z') {
        sArr[S.charAt(idx) - 'a']++;
      } else {
        sArr[S.charAt(idx) - 'A' + 26]++;
      }
      size++;

      if (size == w) {
        if (Arrays.equals(wArr, sArr)) {
          count++;
        }
        if ('a' <= S.charAt(start) && S.charAt(start) <= 'z') {
          sArr[S.charAt(start) - 'a']--;
        } else {
          sArr[S.charAt(start) - 'A' + 26]--;
        }
        start++;
        size--;
      }
    }
    System.out.println(count);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    w = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    W = br.readLine().trim();
    S = br.readLine().trim();

    for (char ch : W.toCharArray()) {
      if ('a' <= ch && ch <= 'z') {
        wArr[ch - 'a']++;
      } else {
        wArr[ch - 'A' + 26]++;
      }
    }

    solve();

  }
}