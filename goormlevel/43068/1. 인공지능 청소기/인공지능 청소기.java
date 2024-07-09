import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine().trim());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine().trim());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			if(Math.abs(X) + Math.abs(Y) > N) {
				sb.append("NO").append("\n");
			} else if(Math.abs(X) + Math.abs(Y) == N) {
				sb.append("YES").append("\n");
			}else if((N - Math.abs(X) - Math.abs(Y)) % 2 == 0) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		
		System.out.print(sb);
	}
}