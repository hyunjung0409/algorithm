import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] input = new int[N][2];
		int[] rank = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        //나보다 덩치가 큰 사람이 있으면 cnt++하여 등수를 낮춘다.
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if(input[i][0]<input[j][0] && input[i][1]<input[j][1]) {
					cnt++;
				}
			}
			rank[i] = cnt;
		}
		
		for (int i = 0; i < rank.length; i++) {			
			sb.append(rank[i]+ " ");
		}
		
		System.out.println(sb.toString());
		
	}

}
