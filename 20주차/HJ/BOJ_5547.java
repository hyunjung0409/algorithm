//https://www.acmicpc.net/problem/5547
//일루미네이션 골드5

import java.io.*;
import java.util.*;

public class BOJ_5547 {
	
	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	//r, c 좌표 반전 필요
	static int[][] even = {{-1,-1}, {-1,0}, {0,1}, {1,0}, {1,-1}, {0,-1}};
	static int[][] odd = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {0,-1}};
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+2][W+2];
		visited = new boolean[H+2][W+2];
		
		for (int i = 1; i <= H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 1; i <= H; i++) {
//			for (int j = 1; j <= W; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		visited[0][0] = true;
		queue.add(new Point(0,0));
		
		while(!queue.isEmpty()) {
			Point cur = queue.remove();
			
			for (int i = 0; i < 6; i++) {
				int nr, nc;
				
				if(cur.r%2 == 0) {	//짝수
					nr = cur.r + even[i][0];
					nc = cur.c + even[i][1];
				} else {	//홀수
					nr = cur.r + odd[i][0];
					nc = cur.c + odd[i][1];
				}
				
				//범위 안에 있고 방문하지 않은 좌표
				if(nr>=0 && nr<=H+1 && nc>=0 && nc<=W+1 && !visited[nr][nc]) {
					if(map[nr][nc] == 0) { //건물이 아닌 경우에만 큐에 넣어준다.
						visited[nr][nc] = true;
						queue.add(new Point(nr, nc));
					}
				}
			}
		}
		
		//외벽 카운트
		int sum = 0;
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				if(map[i][j] == 0) continue; //건물이 아니면 pass
				
				//건물인 경우, 6방 탐색을 하면서 건물이 아닌 경우가 외벽이 되므로 count
				for (int dir = 0; dir < 6; dir++) {
					int nr, nc;
					if(i%2 == 0) {	//짝수
						nr = i + even[dir][0];
						nc = j + even[dir][1];
					} else {	//홀수
						nr = i + odd[dir][0];
						nc = j + odd[dir][1];
					}
					
					if(visited[nr][nc])
						sum++;
				}
			}
		}
		return sum;
	}
}
