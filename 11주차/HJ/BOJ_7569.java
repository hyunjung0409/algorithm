//BOJ/골드5/토마토/40분
import java.io.*;
import java.util.*;

public class BOJ_7569 {

	static int N, M, H, green = 0;
	static int[][][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 0, 1, 0, 0, 0};
	static int[] dc = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	static Queue<Point> queue = new LinkedList<>();
	
	static class Point{
		int r, c, h, cnt;
		public Point(int r, int c, int h, int cnt) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][M][H];
		visited = new boolean[N][M][H];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					
					//익은 토마토일 때,
					if(map[j][k][i] == 1) {
						queue.add(new Point(j, k, i, 1)); //시작점을 큐에 추가
						visited[j][k][i] = true; //방문 처리
					}
					//익지 않은 토마토일 때,
					else if(map[j][k][i] == 0) {
						green++; //카운트 증가
					}
				}
			}
		}
		
		if(green == 0) 
			System.out.println(0);
		else
			System.out.println(bfs());
	}
	
	private static int bfs() {
		
		while(!queue.isEmpty()) {
			Point cur = queue.remove();
			
			for (int i = 0; i < 6; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				int nh = cur.h + dh[i];
				
				//새로운 좌표가 범위 안에 있고, 방문하지 않은 곳일 때
				if(nr>=0 && nr<N && nc>=0 && nc<M && nh>=0 && nh<H && !visited[nr][nc][nh]) {
					//토마토가 없으면 패스
					if(map[nr][nc][nh] == -1) continue;
					
					//익지 않은 토마토
					else if(map[nr][nc][nh] == 0) {
						map[nr][nc][nh] = 1; //익은 토마토 처리
						green--; //익지 않은 토마토 감소
						visited[nr][nc][nh] = true;//방문처리
						
						//종료조건
						if(green == 0) return cur.cnt;					

						//새로운 좌표와 cnt 증가하여 큐에 추가
						queue.add(new Point(nr, nc, nh, cur.cnt+1));
					}
				}
				
			}//육방탐색 끝
		}
		
		return -1;
	}

}