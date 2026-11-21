import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int n, a, b, c, p, q;

    static int distance(int x, int y) {
        int d = Math.abs(x - y) % n;
        return Math.min(d, n - d);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine().trim());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        int d = a;

        int[] pCandidates = {c % n, (n - c) % n};
        int[] qCandidates = {p % n, (n - p) % n};

        int ans = -1;
        for (int pos : pCandidates)  {
            if (distance(d, pos) != b) continue;;
            for (int x : qCandidates) {
                if (distance(d, x) != q) continue;;
                ans = distance(pos, x);
            }
        }
        System.out.println(ans);
    }
}
