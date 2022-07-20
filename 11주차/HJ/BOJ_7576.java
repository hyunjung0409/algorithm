 // BOJ/골드5/토마토/1시간10분
import java.io.*;
import java.util.*;

public class BOJ_7576 {

	static int N, M, green = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<Point> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					list.add(new Point(i, j, 0)); //익은 토마토 좌표를 list에 추가
				}else if(map[i][j] == 0) {
					green++; //안익은 토마토 개수를 카운트
				}
			}
		}
		
		if(green == 0)
			System.out.println(0);
		else 
			System.out.println(bfs());
		
	}
	
	static class Point{
		int r, c, cnt;
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	private static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			Point start = list.get(i);
			visited[start.r][start.c] = true;
			queue.add(new Point(start.r, start.c, 1));
		}		
		
		while(!queue.isEmpty()) {
			Point cur = queue.remove();
			
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				//좌표가 범위 안에 있고 방문하지 않았으면
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
					//토마토 들어있지 않으면 패스
					if(map[nr][nc] == -1) continue;
					
					//익지 않은 토마토
					else if(map[nr][nc] == 0 ) {
						map[nr][nc] = 1;		//익은 토마토 처리
						green--;	//익지 않은 토마토 감소
						visited[nr][nc] = true;	//방문처리
						
						//토마토가 다 익었을 때 (종료조건)
						if(green == 0) return cur.cnt;
						
						//좌표, 카운트 추가
						queue.add(new Point(nr, nc, cur.cnt+1));
					}
				}
			}//사방탐색 종료
			
		}
		
		return -1;
	}

}