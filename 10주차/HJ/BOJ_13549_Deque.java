import java.io.*;
import java.util.*;

public class BOJ_13549_Deque {

	static int N, K, max = 100000, min = Integer.MAX_VALUE;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		//N, K를 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//visited[] 생성
		visited = new boolean[max+1];
		
		bfs(N);
		
		//time 출력
		System.out.println(min);
	}

	static class Point {
		int x, time; //x 위치, 시간 count
		
		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	//BFS를 하기 위해서는 모든 간선의 가중치가 동일해야 한다는 전제 조건이 필요하다.
	//가중치가 0인 간선이 있는 경우에 BFS로 풀이하기 위해서는, 가중치가 0인 간선에 연결된 정점은 큐의 맨 뒤가 아닌 "맨 앞"에 넣는 방법으로 풀이한다.
	//0-1 BFS
	private static void bfs(int x) {	
		//0-1 BFS를 위해 덱 생성 -> (x, time) 삽입
		Deque<Point> dq = new LinkedList<>();
		dq.add(new Point(x, 0));
	
		//초기값 방문처리
		visited[x] = true;
		
		while(!dq.isEmpty()) {
			// 현재값
			Point cur = dq.remove();
			int cx = cur.x;
			int ctime = cur.time;
			
			//종료조건. x가 K이면 최소 time 판별하고 리턴
			if(cx == K) {
				min = Math.min(min, ctime);
				return;
			}
		
			//조건에 따라 처리 ( 0 -> 덱 맨 앞에 추가, 1 or -1 -> 덱 뒤에 추가 )
			if(cx*2 >= 0 && cx*2 <= max && visited[cx*2] == false) {
				visited[cx*2] = true;
				dq.addFirst(new Point(cx*2, ctime));
			}
			if(cx+1 >= 0 && cx+1 <= max && visited[cx+1] == false) {
				visited[cx+1] = true;
				dq.add(new Point(cx+1, ctime+1));
			}
			if(cx-1 >= 0 && cx-1 <= max && visited[cx-1] == false) {
				visited[cx-1] = true;
				dq.add(new Point(cx-1, ctime+1));
			}
			
		}
	} //end of BFS

}
