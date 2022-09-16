import java.io.*;
import java.util.*;

public class BOJ_1890 {
	
	static int[][] map;
	static long[][] memo;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		memo = new long[n][n];
		///map 입력
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//카운트 초기값
		memo[0][0] = 1;
		
		//map 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//종착점 도착하면 break
				if(i == n-1 && j == n-1) break;
				
				int next = map[i][j];	//이동거리
				
				//이동 좌표가 범위 안에 있으면 memoization
				if(i+next < n)
					memo[i+next][j] += memo[i][j];
				if(j+next < n)
					memo[i][j+next] += memo[i][j];
			}
		}
		
		System.out.println(memo[n-1][n-1]);
		
	}

}
