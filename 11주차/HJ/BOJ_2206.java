// BOJ/벽 부수고 이동하기/골드4/1시간

import java.io.*;
import java.util.*;

public class BOJ_2206 {

	static int N, M;
	static int[][] map, visited;	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				// 1이면 벽, 0이면 벽 아님
				map[i][j] = str.charAt(j) - '0';
				
				// 공사횟수
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		System.out.println(BFS(0, 0, 0, 1));

	}
	
	static class Point{
		int r, c, wall, cnt;
		
		public Point(int r, int c, int wall, int cnt) {
			this.r = r;
			this.c = c;
			this.wall = wall;
			this.cnt = cnt;
		}
	}

	private static int BFS(int r, int c, int wall, int cnt) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c, wall, cnt));
		visited[r][c] = 0; //처음 공사횟수
		
		while(!queue.isEmpty()) {
			Point cur = queue.remove();
			
			if(cur.r == N-1 && cur.c == M-1) {
				return cur.cnt;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr>= 0 && nr<N && nc>=0 && nc<M && visited[nr][nc] > cur.wall) {
					
					//벽이 아닌 경우
					if(map[nr][nc] == 0) {
						visited[nr][nc] = cur.wall;
						queue.add(new Point(nr, nc, cur.wall, cur.cnt+1));
					}
					//벽인 경우
					else {
						if(cur.wall == 0) { //한번만 뚫고 지나갈 수 있으므로,,,
							visited[nr][nc] = cur.wall + 1;
							queue.add(new Point(nr, nc, cur.wall+1, cur.cnt+1));
						}
					}
					
				}
			}
			
		}
		return -1;
	}//end of bfs

}
