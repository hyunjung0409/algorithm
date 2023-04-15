import java.io.*;
import java.util.*;

public class BOJ_16935 {
	static int[][] map, tempMap;
	static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 연산개수

		map = new int[N][M];
        
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 배열 입력

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

	private static void one() {
        tempMap = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tempMap[N-r-1][c] = map[r][c];
			}
		}
        map = tempMap;
	}// 상하 반전

	private static void two() {
        tempMap = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tempMap[r][M-c-1] = map[r][c];
			}
		}
        map = tempMap;
	}// 좌우 반전

	private static void three() {
		tempMap = new int[M][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				tempMap[c][N-r-1] = map[r][c];
			}
		}

        //배열 행/열 크기 변경
        int temp = N;
        N = M;
        M = temp;

		map = tempMap;
    }// 오른쪽 90도 회전

	private static void four() {
		tempMap = new int[M][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tempMap[M-c-1][r] = map[r][c];
			}
		}

         //배열 행/열 크기 변경
         int temp = N;
         N = M;
         M = temp;

		map = tempMap;
	}// 왼쪽 90도 회전

	private static void five() {
		tempMap = new int[N][M];

		// 1->2
		for (int r = 0; r < N/2; r++) {
			for (int c = 0; c < M/2; c++) {
				tempMap[r][c + M/2] = map[r][c];
			}
		}

		// 2->3
		for (int r = 0; r < N/2; r++) {
			for (int c = M/2; c < M; c++) {
				tempMap[r + N/2][c] = map[r][c];
			}
		}

		// 3->4
		for (int r = N/2; r < N; r++) {
			for (int c = M/2; c < M; c++) {
				tempMap[r][c - M/2] = map[r][c];
			}
		}

		// 4->1
		for (int r = N/2; r < N; r++) {
			for (int c = 0; c < M/2; c++) {
				tempMap[r - N/2][c] = map[r][c];
			}
		}
		map = tempMap;
	}// 4개 집합 시계방향

	private static void six() {
		tempMap = new int[N][M];

		// 1->4
		for (int r = 0; r < N/2; r++) {
			for (int c = 0; c < M/2; c++) {
				tempMap[r + N/2][c] = map[r][c];
			}
		}

		// 4->3
		for (int r = N/2; r < N; r++) {
			for (int c = 0; c < M/2; c++) {
				tempMap[r][c + M/2] = map[r][c];
			}
		}

		// 3->2
		for (int r = N/2; r < N; r++) {
			for (int c = M/2; c < M; c++) {
				tempMap[r - N/2][c] = map[r][c];
			}
		}

		// 2->1
		for (int r = 0; r < N/2; r++) {
			for (int c = M/2; c < M; c++) {
				tempMap[r][c - M/2] = map[r][c];
			}
		}
		map = tempMap;

	}// 4개 집합 반시계방향

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
