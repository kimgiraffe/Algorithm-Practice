import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 옥상_정원_꾸미기
 */
public class Main {
  static BufferedReader br;
  static int N; // 빌딩의 수
  static int[] h;
  static Stack<Integer> stack = new Stack<>();
  static long answer;

  static void solve() {
    for (int idx = 0; idx < N; idx++) {
      if (stack.isEmpty()) {
        stack.push(h[idx]);
        continue;
      }
      while (!stack.isEmpty() && stack.peek() <= h[idx]) { // 확인할 수 없는 건물을 스택에서 pop
        stack.pop();
      }
      answer += stack.size();
      stack.push(h[idx]);
    }

    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine().trim());
    h = new int[N];

    for (int idx = 0; idx < N; idx++) {
      h[idx] = Integer.parseInt(br.readLine().trim());
    }

    solve();
  }
}