import java.util.*;
import java.io.*;

/**
 * 1024. 수열의 합
 * 
 * N과 L이 주어질 때, 합이 N이면서, 길이가 적어도 L인 가장 짧은 연속된 음이 아닌 정수 리스트를 구하는 프로그램을 작성하시오.
 * 
 * 45 10 -> 0 1 2 3 4 5 6 7 8 9
 * 1000000000 2 -> 199999998 199999999 200000000 200000001 200000002
 */

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, L;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int count = 0;
        int start = -1;

        for (int i = L; i <= 100; i++) {
            int t = (i * (i - 1)) / 2;

            if ((N - t) % i == 0 && (N - t) / i >= 0) {
                count = i;
                start = (N - t) / i;
                break;
            }
        }

        if (start < 0) {
            sb.append(start);
        }

        for (int i = 0; i < count; i++) {
            sb.append(start + i).append(" ");
        }

        System.out.println(sb.toString());
    }
}