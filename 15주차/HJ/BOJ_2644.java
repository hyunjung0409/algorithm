import java.io.*;
import java.util.*;

public class BOJ_2644 {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int result = -1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//전체 사람
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}

		//촌수 계산해야 하는 사람들
		StringTokenizer st = new StringTokenizer(br.readLine());
		int person1 = Integer.parseInt(st.nextToken());
		int person2 = Integer.parseInt(st.nextToken());
		
		//부모, 자식 관계 개수
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //부모
			int y = Integer.parseInt(st.nextToken()); //자식
			list[x].add(y);
			list[y].add(x);
		}
		
		dfs(person1, person2, 0);
		System.out.println(result);
	}

	static void dfs(int start, int end, int cnt) {
		if(start == end) {
			result = cnt;
			return;
		}
		
		visited[start] = true;
		for (int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			if(!visited[next]) {
				dfs(next, end, cnt+1);
			}
		}
	}
	
}
