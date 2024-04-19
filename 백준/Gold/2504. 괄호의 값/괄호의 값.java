import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호의_값
 */
public class Main {
  static BufferedReader br;
  static String str;
  static Stack<Character> stack = new Stack<>();
  static int answer, tmp = 1;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    str = br.readLine().trim();

    for (int idx = 0; idx < str.length(); idx++) {
      if (str.charAt(idx) == '(') {
        tmp *= 2;
        stack.push('(');
      } else if (str.charAt(idx) == '[') {
        tmp *= 3;
        stack.push('[');
      } else if (str.charAt(idx) == ')') {
        if (stack.isEmpty() || stack.peek() != '(') {
          answer = 0;
          break;
        }
        if (str.charAt(idx - 1) == '(') {
          answer += tmp;
          tmp /= 2;
          stack.pop();
        } else {
          tmp /= 2;
          stack.pop();
        }
      } else if (str.charAt(idx) == ']') {
        if (stack.isEmpty() || stack.peek() != '[') {
          answer = 0;
          break;
        }
        if (str.charAt(idx - 1) == '[') {
          answer += tmp;
          tmp /= 3;
          stack.pop();
        } else {
          tmp /= 3;
          stack.pop();
        }
      }
    }

    if (!stack.isEmpty()) {
      answer = 0;
    }

    System.out.println(answer);
  }
}