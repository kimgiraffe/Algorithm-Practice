import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 나이순_정렬
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int N;

  static class Member implements Comparable<Member> {
    int age;
    String name;

    public Member(int age, String name) {
      this.age = age;
      this.name = name;
    }

    @Override
    public int compareTo(Member o) {
      return Integer.compare(this.age, o.age);
    }
  }

  static Member[] members;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    N = Integer.parseInt(br.readLine().trim());
    members = new Member[N];

    for (int idx = 0; idx < N; idx++) {
      st = new StringTokenizer(br.readLine().trim());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      members[idx] = new Member(age, name);
    }

    Arrays.sort(members);

    for (int idx = 0; idx < N; idx++) {
      sb.append(members[idx].age).append(" ").append(members[idx].name).append("\n");
    }

    System.out.print(sb);
  }
}