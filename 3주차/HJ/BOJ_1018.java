import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char board[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		int cnt_w, cnt_b;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N-7 ; i++) {
			for (int j = 0; j < M-7; j++) {
				cnt_b = 0;
				cnt_w = 0;
				for (int r = i; r < i+8; r++) {
					for (int c = j; c < j+8; c++) {
						if( (r+c)%2 == 0 ) {
							if(board[r][c]== 'B') {
								cnt_b++;
							}else {
								cnt_w++;
							}
						}else {
							if(board[r][c]== 'B') {
								cnt_w++;
							}else {
								cnt_b++;
							}
						}
						
					}
				}
				min = Math.min(min, Math.min(cnt_b, cnt_w));
			}
		}
		System.out.println(min);
	}

}
