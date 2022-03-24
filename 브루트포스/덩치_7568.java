import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 덩치7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] info = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			String[] num = br.readLine().split(" ");
			
			info[i][0] = Integer.parseInt(num[0]);
			info[i][1] = Integer.parseInt(num[1]);
		}
		
		for (int i = 0; i < N; i++) {
			int rank = 1; //1순위부터 시작
			
			for (int j = 0; j < N; j++) { 
				if (i == j) //같은 사람은 비교할 필요 없음
					continue;
				
				if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) //i가 j보다 덩치가 작으면 순위가 1씩 밀림
					rank++;
			}
			
			System.out.print(rank + " ");
		}
	

	}

}
