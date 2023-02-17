import java.io.*;
import java.util.*;

public class BOJ_1780 {

	// -1: negative, 0: zero, 1: positive
	static int N, negative=0, zero=0, positive=0;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		split(0, 0, N);
		
		System.out.println(negative);
		System.out.println(zero);
		System.out.println(positive);
	}
	 
	private static void split(int row, int col, int size) {
		if(check(row, col, size)) {
			if(arr[row][col] == -1)
				negative++;
			else if(arr[row][col] == 0)
				zero++;
			else
				positive++;
			
			return;
		}
		
		int newSize = size/3;
		
		split(row, col, newSize);
		split(row, col + newSize, newSize);
		split(row, col + 2*newSize, newSize);
		
		split(row + newSize, col, newSize);
		split(row + newSize, col + newSize, newSize);
		split(row + newSize, col + 2*newSize, newSize);
		
		split(row + 2*newSize, col, newSize);
		split(row + 2*newSize, col + newSize, newSize);
		split(row + 2*newSize, col + 2*newSize, newSize);
		
	}
	
	private static boolean check(int row, int col, int size) {
		int num = arr[row][col];
		
		for (int i = row; i < row+size; i++) {
			for (int j = col; j < col+size; j++) {
				if(num != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
