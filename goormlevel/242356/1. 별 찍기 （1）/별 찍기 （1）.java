import java.io.*;
class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int N;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine().trim());
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}