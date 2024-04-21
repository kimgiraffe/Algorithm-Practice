import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 도키도키_간식드리미
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static int N;
  static Queue<Integer> queue;
  static Stack<Integer> stack;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine().trim());

    st = new StringTokenizer(br.readLine().trim());

    queue = new ArrayDeque<>();
    stack = new Stack<>();

    for (int idx = 0; idx < N; idx++) {
      queue.offer(Integer.parseInt(st.nextToken()));
    }

    int start = 1;

    while (!queue.isEmpty()) {
      if (queue.peek() == start) {
        queue.poll();
        start++;
      } else if (!stack.isEmpty() && stack.peek() == start) {
        stack.pop();
        start++;
      } else {
        stack.push(queue.poll());
      }
    }

    while (!stack.isEmpty()) {
      if (stack.peek() == start) {
        stack.pop();
        start++;
      } else {
        System.out.println("Sad");
        return;
      }
    }

    System.out.println("Nice");

  }
}