import java.io.*;
import java.util.*;

public class BOJ_9465 {
	static int n, t;
	static int[][] arr, memo;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {			
			n = Integer.parseInt(br.readLine());
			arr = new int[2][n+1];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n+1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			memo = new int[2][n+1];
			memo[0][1] = arr[0][1];
			memo[1][1] = arr[1][1];

			for (int i = 2; i <= n; i++) {
				memo[0][i] = Math.max(memo[1][i-2], memo[1][i-1]) + arr[0][i];
				memo[1][i] = Math.max(memo[0][i-2], memo[0][i-1]) + arr[1][i];
			}
			
			sb.append((Math.max(memo[0][n], memo[1][n]))).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}