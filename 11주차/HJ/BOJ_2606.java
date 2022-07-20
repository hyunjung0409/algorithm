// BOJ/실버3/바이러스/45분
import java.io.*;
import java.util.*;

public class BOJ_2606 {
	
	static int N, M; //정점, 간선의 개수
	static int[][] map; //인접행렬
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[b][a] = 1;
		}
		
		bfs(1);
	}

	
	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[0] = true;
		visited[n] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			
      //차례대로 1번과 연결된 컴퓨터를 찾아 cnt 증가
			for (int i = 1; i < map.length; i++) {
				if(map[cur][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					cnt++;
				}
			}
			
		}
		System.out.println(cnt);
	}

}
