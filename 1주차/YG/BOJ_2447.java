import java.util.*;
public class BOJ_2447 {
	static String[][]arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		arr = new String[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = " ";
			}
		}
		
		star(0, 0, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	private static void star(int r, int c, int n) {
		if (n == 1) {
			arr[r][c] = "*";
			
			return;
		}
		
		int cnt = 0;

		
		for (int i = 0 ; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cnt++;
				if (cnt != 5) {
					star(r + i * (n / 3) , c + j * (n / 3), n / 3);
				}
			}
		}
		
	}

}
