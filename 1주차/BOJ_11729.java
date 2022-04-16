import java.util.*;
public class 하노이탑이동순서_11729 {
	static int K;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sb = new StringBuilder();
		
		hanoitop(N, 1, 2, 3);

		sb.insert(0, K + "\n");
		System.out.println(sb);

	}

	private static void hanoitop(int n, int start, int mid, int des) {
		K++;
		
		if (n == 1) {
			sb.append(start + " " + des + " \n");
			
			return;
		}
		
		hanoitop(n - 1, start, des, mid); //A에서 B로 이동
		
		sb.append(start + " " + des + "\n");
		
		hanoitop(n - 1, mid, start, des); //B에서 C로 이동
		

	}

}