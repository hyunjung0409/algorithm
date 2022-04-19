import java.util.*;
public class BOJ_2447 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		star(N);

	}

	private static void star(int n) {
		if (n == 1) {
			System.out.print("*");
			
			return;
		}
		
		star(n / 3);
		
		for (int i = 0 ; i < n; i++) {
			System.out.print("*");
			if (i == 5) {
				System.out.print(" ");
			}
		}
		
	}

}
