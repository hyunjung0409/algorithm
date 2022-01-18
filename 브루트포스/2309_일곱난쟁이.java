import java.util.*;

public class 일곱난쟁이2309 {
	static int[] ans;
	static int[] height;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = new int[9];
		
		for (int i = 0; i < 9; i++) {
			height[i] = sc.nextInt();
		}
		
		ans = new int[7];
		
		combination(0, 0);

	}

	private static void combination(int cnt, int start) {
		if (cnt == 7) {
			int total = 0;
			
			for (int i = 0; i < 7; i++) {
				total += ans[i];
			}
			
			if (total == 100) {
				Arrays.sort(ans);
				
				for (int i = 0; i < 7; i++) {
					System.out.println(ans[i]);
				}
			}
			
			return;
		}
		
		for (int i = start; i < 9; i++) {
			ans[cnt] = height[i];
			combination(cnt + 1, i + 1);
		}
		
	}

}
