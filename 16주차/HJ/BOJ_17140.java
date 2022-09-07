import java.io.*;
import java.util.*;

public class BOJ_17140 {

	static int R, C, K;
	static int[][] A = new int[101][101];
	static int rSize, cSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//input
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solution());
	}
	
	private static int solution() {
		//100초 동안 연산
		for (int time = 0; time <= 100; time++) {
			//종료 조건
			if(A[R][C] == K)
				return time;
			
			//R연산 혹은 C연산 수행
			if(rSize >= cSize) {
				calculate_R();
			}else {
				calculate_C();
			}
		}
		
		//100초 넘어도 조건 만족 x
		return -1;
	}

	private static void calculate_R() {
		//모든 행에 대해 R연산 수행
		for (int r = 1; r <= rSize; r++) {
			//각 숫자와 횟수를 담을 HashMap 선언
			HashMap<Integer, Integer> map = new HashMap<>(); // <number, count>
			
			//숫자와 횟수를 카운트하여 map에 담음
			for (int c = 1; c <= cSize; c++) {
				if(A[r][c] == 0)
					continue;
				
				map.put(A[r][c], map.getOrDefault(A[r][c], 0) + 1);
				
				//카운트 된 숫자는 미리 0으로 변환
				A[r][c] = 0;
			}
			
			
			
		}
	}

	private static void calculate_C() {

		
	}


}
