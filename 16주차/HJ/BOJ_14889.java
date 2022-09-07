import java.io.*;
import java.util.*;

public class BOJ_14889 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[][] S;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//input
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		visited = new boolean[N];
		
		//능력치 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(min);
		
	}

	private static void dfs(int idx, int cnt) {
		//종료 조건
		if(cnt == N/2) {
			//능력차 계산
			calculate_diff();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if(!visited[i]) { 		//방문하지 않은 경우
				visited[i] = true;  //방문 처리
				dfs(i+1, cnt+1); 	//재귀 호출
				visited[i] = false; //재귀가 끝나면 다시 비방문 처리
			}
		}
	}

	private static void calculate_diff() {
		int start = 0, link = 0; //스타트 팀, 링크 팀 능력치 초기화
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				//true인 사람들을 스타트 팀으로 계산
				if(visited[i] == true && visited[j] == true) {
					start += S[i][j];
					start += S[j][i];
				}
				//false인 사람들을 링크 팀으로 계산
				else if(visited[i] == false && visited[j] == false) {
					link += S[i][j];
					link += S[j][i];
				}
			}
		}
		
		int diff = Math.abs(start - link);
		min = Math.min(diff, min);
	}
}
