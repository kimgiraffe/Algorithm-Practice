import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문자열_폭발
 */
public class Main {
  static BufferedReader br;
  static Stack<Character> stack = new Stack<>();
  static StringBuilder sb;
  static String answer;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine().trim();
    String bomb = br.readLine().trim();

    for (int idx = 0; idx < str.length(); idx++) {
      stack.push(str.charAt(idx));

      if (stack.size() >= bomb.length()) {
        boolean flag = true;
        for (int j = 0; j < bomb.length(); j++) {
          if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
            flag = false;
            break;
          }
        }
        if (flag) {
          for (int j = 0; j < bomb.length(); j++) {
            stack.pop();
          }
        }
      }
    }

    sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    System.out.println(sb.length() == 0 ? "FRULA" : sb.reverse());
  }
}