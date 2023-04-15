import java.io.*;
import java.util.*;

public class BOJ_16935_copy {
	static int[][] map, tempMap;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 연산개수

		map = new int[N][M];
        
		// 배열 입력
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		} 

		// rotate 함수 유형 입력
        st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int command = Integer.parseInt(st.nextToken());
			rotate (command);
        }
        
		print();
	} // main close

    private static void rotate(int command) {
		switch(command) {
	    	case 1: one();
	    		break;
	    	case 2: two();
	    		break;
	    	case 3: three();
	    		break;
	    	case 4: four();
	    		break;
	    	case 5: five();
	    		break;
	    	case 6: six();
	    		break;
    	}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				sb.append(map[n][m] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void updateLength() {
		N = map.length;
		M = map[0].length;
	}

	// 상하 반전
	private static void one() {
		updateLength();
        tempMap = new int[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempMap[N-n-1][m] = map[n][m];
			}
		}
        map = tempMap;
	}

	// 좌우 반전
	private static void two() {
		updateLength();
        tempMap = new int[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempMap[n][M-m-1] = map[n][m];
			}
		}
        map = tempMap;
	}

	// 오른쪽 90도 회전
	private static void three() {
		updateLength();
		tempMap = new int[M][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempMap[m][N-n-1] = map[n][m];
				System.out.println("map[n][m]: "+ map[n][m]);
				System.out.println("tempMap[N-n-1][m]: "+ tempMap[N-n-1][m]);
				// tempMap[N-n-1][m] = map[n][m];
			}
		}
        //배열 행/열 크기 변경
        int temp = N;
        N = M;
        M = temp;

		map = tempMap;
    }

	// 왼쪽 90도 회전
	private static void four() {
		updateLength();
		tempMap = new int[M][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				tempMap[M-m-1][n] = map[n][m];
			}
		}
         //배열 행/열 크기 변경
         int temp = N;
         N = M;
         M = temp;

		map = tempMap;
	}


	// 4개 집합 시계방향
	private static void five() {
		updateLength();
		tempMap = new int[N][M];
		// 1->2
		for (int n = 0; n < N/2; n++) {
			for (int m = 0; m < M/2; m++) { //1번 영역
				//2번 영역에 1번 영역 값 입력 
				tempMap[n][m + M/2] = map[n][m];
			}
		}

		// 2->3
		for (int n = 0; n < N/2; n++) {
			for (int m = M/2; m < M; m++) { //2번 영역
				//3번 영역에 2번 영역 값 입력
				tempMap[n + N/2][m] = map[n][m];
			}
		}

		// 3->4
		for (int n = N/2; n < N; n++) {
			for (int m = M/2; m < M; m++) { //3번 영역
				//4번 영역에 3번 영역 값 입력
				tempMap[n][m - M/2] = map[n][m];
			}
		}

		// 4->1
		for (int n = N/2; n < N; n++) {
			for (int m = 0; m < M/2; m++) { //4번 영역
				//1번 영역에 4번 영역 값 입력
				tempMap[n - N/2][m] = map[n][m];
			}
		}
		map = tempMap;
	}

	// 4개 집합 반시계방향
	private static void six() {
		updateLength();
		tempMap = new int[N][M];
		// 1->4
		for (int n = 0; n < N/2; n++) {
			for (int m = 0; m < M/2; m++) { //1번 영역
				//4번 영역에 1번 영역 값 입력
				tempMap[n + N/2][m] = map[n][m];
			}
		}

		// 4->3
		for (int n = N/2; n < N; n++) {
			for (int m = 0; m < M/2; m++) { //4번 영역
				//3번 영역에 4번 영역 값 입력
				tempMap[n][m + M/2] = map[n][m];
			}
		}

		// 3->2
		for (int n = N/2; n < N; n++) {
			for (int m = M/2; m < M; m++) { //3번 영역
				//2번 영역에 3번 영역 값 입력
				tempMap[n - N/2][m] = map[n][m];
			}
		}

		// 2->1
		for (int n = 0; n < N/2; n++) {
			for (int m = M/2; m < M; m++) { //2번 영역
				tempMap[n][m - M/2] = map[n][m];
			}
		}
		map = tempMap;
	}
}
