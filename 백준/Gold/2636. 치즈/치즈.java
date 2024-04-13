import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 치즈
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;

  static int r, c;
  static int[][] map;
  static int cheese, cnt, time;
  static boolean[][] visited;
  static final int[] DELTA_ROW = { -1, 0, 1, 0 };
  static final int[] DELTA_COL = { 0, 1, 0, -1 };

  static class Pos {
    int row;
    int col;

    public Pos(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  static boolean isInRange(int row, int col) {
    return row >= 0 && row < r && col >= 0 && col < c;
  }

  static void bfs() {
    Queue<Pos> queue = new ArrayDeque<>();
    queue.offer(new Pos(0, 0));

    visited[0][0] = true;

    while (!queue.isEmpty()) {
      Pos cur = queue.poll();

      for (int dir = 0; dir < 4; dir++) {
        int nextRow = cur.row + DELTA_ROW[dir];
        int nextCol = cur.col + DELTA_COL[dir];

        if (isInRange(nextRow, nextCol) && !visited[nextRow][nextCol]) {
          visited[nextRow][nextCol] = true;
          if (map[nextRow][nextCol] == 0) {
            queue.offer(new Pos(nextRow, nextCol));
          } else {
            cheese--;
            map[nextRow][nextCol] = 0;
          }
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine().trim());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    map = new int[r][c];

    for (int row = 0; row < r; row++) {
      st = new StringTokenizer(br.readLine().trim());
      for (int col = 0; col < c; col++) {
        map[row][col] = Integer.parseInt(st.nextToken());
        if (map[row][col] == 1) {
          cheese++;
        }
      }
    }

    while (cheese > 0) {
      time++;
      cnt = cheese;
      visited = new boolean[r][c];
      bfs();
    }

    System.out.println(time);
    System.out.println(cnt);
  }
}