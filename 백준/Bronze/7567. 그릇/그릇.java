import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;

    static String str;
    static int result = 10;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().trim();

        for (int idx = 1; idx < str.length(); idx++) {
            if (str.charAt(idx) == str.charAt(idx - 1)) {
                result += 5;
            } else {
                result += 10;
            }
        }

        System.out.println(result);
    }
}