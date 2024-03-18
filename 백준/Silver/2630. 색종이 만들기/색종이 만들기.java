import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int N; // 종이의 한 변의 길이
    static int[][] map;
    static int whiteCount, blueCount;
    static final int WHITE = 0;
    static final int BLUE = 1;

    static void divideAndConquer(int r, int c, int size) {
        boolean flag = true;

        int color = map[r][c];

        for (int row = r; row < r + size; row++) {
            for (int col = c; col < c + size; col++) {
                if (color != map[row][col]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }

        if (flag) {
            if (color == WHITE) {
                whiteCount++;
            } else {
                blueCount++;
            }
        } else {
            divideAndConquer(r, c, size / 2);
            divideAndConquer(r + size / 2, c, size / 2);
            divideAndConquer(r, c + size / 2, size / 2);
            divideAndConquer(r + size / 2, c + size / 2, size / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        map = new int[N][N];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, N);

        System.out.println(whiteCount + "\n" + blueCount);
    }

}
