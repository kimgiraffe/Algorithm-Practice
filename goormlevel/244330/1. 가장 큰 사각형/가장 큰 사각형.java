import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static int T;
	static int maxArea;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int area = a * b;
			if(area > maxArea) {
				maxArea = area;
			}
		}
		
		System.out.print(maxArea);
	}
}