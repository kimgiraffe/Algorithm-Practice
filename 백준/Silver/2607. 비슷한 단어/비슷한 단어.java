import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 비슷한_단어
 */
public class Main {
  static BufferedReader br;
  static int N;
  static String[] strings;
  static int[] alp = new int[26];
  static int[] copy;
  static int answer;

  static void compare(String s1, String s2) {
    if (Math.abs(s1.length() - s2.length()) > 1) {
      return;
    }
    int cnt = 0;

    for (int idx = 0; idx < s2.length(); idx++) {
      if (copy[s2.charAt(idx) - 'A'] > 0) {
        cnt++;
        copy[s2.charAt(idx) - 'A']--;
      }
    }

    if (s1.length() - 1 == s2.length()) {
      if (cnt == s2.length())
        answer++;
    } else if (s1.length() + 1 == s2.length()) {
      if (cnt == s1.length())
        answer++;
    } else if (s1.length() == s2.length()) {
      if (cnt == s1.length())
        answer++;
      else if (cnt == s1.length() - 1)
        answer++;
    }

  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine().trim());
    strings = new String[N];
    for (int idx = 0; idx < N; idx++) {
      strings[idx] = br.readLine().trim();
    }

    String s = strings[0];
    for (int idx = 0; idx < s.length(); idx++) {
      alp[s.charAt(idx) - 'A']++;
    }

    for (int idx = 1; idx < N; idx++) {
      copy = alp.clone();
      compare(s, strings[idx]);

    }

    System.out.println(answer);

  }
}