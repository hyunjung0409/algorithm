import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
	static String[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new String[n][n];
		
    //미리 공백으로 셋팅
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = " ";
			}
		}
		
		star(0, 0, n); //재귀함수 실행
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	private static void star(int r, int c, int n) {
		
    //종료 조건
		if(n == 1) {
			arr[r][c] = "*";
			return;
		}
		
		int cnt = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				cnt++;
//				if(!(i==1 && j==1)) {
//					star(r+i*(n/3), c+j*(n/3), n/3);
//				}
				if(cnt != 5) {
          //공백이지 않은 경우에만 재귀함수 실행
          //공백일 경우 재귀함수 실행되지 않고 continue되어 *이 찍히지 않음
					star(r+i*(n/3), c+j*(n/3), n/3);
				}
			}
		}
		
	}
}
