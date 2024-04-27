import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 컨베이어_벨트_위의_로봇
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int N, K;
  static boolean[] robot;
  static int step;

  static class Belt {
    int durabilty;
    boolean robot;

    public Belt(int durabilty) {
      this.durabilty = durabilty;
      this.robot = false;
    }

    public void put() {
      this.durabilty--;
      this.robot = true;
    }
  }

  static LinkedList<Belt> belts;

  static void moveConveyor() {
    step++;
    belts.add(0, belts.removeLast());
    if (belts.get(N - 1).robot) {
      belts.get(N - 1).robot = false;
    }
  }

  static void moveRobot() {
    for (int idx = N - 1; idx > 0; idx--) {
      if (!belts.get(idx).robot)
        continue;
      if (belts.get(idx + 1).robot || belts.get(idx + 1).durabilty <= 0)
        continue;

      belts.get(idx).robot = false;
      belts.get(idx + 1).put();
      if (belts.get(idx + 1).durabilty <= 0) {
        K--;
      }

      if (idx + 1 == N - 1) {
        belts.get(idx + 1).robot = false;
      }
    }

    if (belts.get(0).durabilty > 0) {
      belts.get(0).put();
      if (belts.get(0).durabilty <= 0)
        K--;
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    robot = new boolean[2 * N];
    belts = new LinkedList<>();

    st = new StringTokenizer(br.readLine().trim());
    for (int idx = 0; idx < 2 * N; idx++) {
      belts.add(idx, new Belt(Integer.parseInt(st.nextToken())));
    }

    while (K > 0) {
      moveConveyor();
      moveRobot();
    }

    System.out.println(step);
  }
}