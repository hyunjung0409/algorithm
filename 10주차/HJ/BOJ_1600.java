// BOJ/골드3/1600/1시간30분
import java.io.*;
import java.util.*;

public class BOJ_1600 {
	//말 움직임 횟수, 맵 가로, 세로, 최소값 초기화
	static int K, W, H, min = Integer.MAX_VALUE;
	static int[][] map; //맵 (0 - 평지, 1 - 장애물)
	
	//말 이동
	static int[] hdr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] hdc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	//원숭이 이동
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	//방문처리 --> 3차원으로 해야 함.
	static boolean[][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//K, W, H, map 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); //5
		H = Integer.parseInt(st.nextToken()); //2
		
		map = new int[H][W];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//방문처리 배열 초기화
		visited = new boolean[H][W][K+1];
		
		//최소값 출력
		System.out.println(bfs(0, 0, K));
		
	}
	
	static class Point{
		int r, c, k, cnt; //행, 열, 말 이동횟수, 총 이동횟수
		public Point(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

	private static int bfs(int r, int c, int k) {
		//큐 -> 초기값 삽입
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r, c, k, 0));
		
		//초기값 방문처리
		visited[r][c][k] = true;
		
		//와일문 -> 현재값 queue remove
		while(!queue.isEmpty()) {
			Point cur = queue.remove();
			int cr = cur.r;
			int cc = cur.c;
			int ck = cur.k;
			int ccnt = cur.cnt;
			
			//종료조건 (r, c -> H-1, W-1) -> min 반환
			if( cr == H-1 && cc == W-1 ) {
				min = Math.min(ccnt, min);
				return min;
			}
			
			//조건에 따라 처리
			//1. 말처럼 이동 (K>0 일 때, 이동...)
			if(ck > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = cr + hdr[i];
					int nc = cc + hdc[i];
					
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] == 0 && !visited[nr][nc][ck-1]) {
						visited[nr][nc][ck-1] = true;
						queue.add(new Point(nr, nc, ck-1, ccnt+1));
					}
				}
			}
			
			//2. 원숭이로 이동 (사방탐색)
			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];
				
				if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc] == 0 && !visited[nr][nc][ck]) {
					visited[nr][nc][ck] = true;
					queue.add(new Point(nr, nc, ck, ccnt+1));
				}
			}
		}
		
		return -1;
	}

}
