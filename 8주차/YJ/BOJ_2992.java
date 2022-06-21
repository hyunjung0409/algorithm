import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_2992 {
	static int min = Integer.MAX_VALUE;
	static String x;
	static boolean selected[];
	static int result;
	static int nums[], ans[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = br.readLine();
		selected = new boolean[x.length()];
		nums = new int[x.length()];
		ans = new int[x.length()];
		
		for (int i = 0; i < x.length(); i++) {
			nums[i] = x.charAt(i) - '0';
		}
		calculation(0);
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else {
			System.out.println(result);
		}
	}

	private static void calculation(int cnt) {
		if (cnt == x.length()) {
			String num = "";
			for (int i = 0; i < ans.length; i++) {
				num += Integer.toString(ans[i]);
			}
			if (Integer.parseInt(num) > Integer.parseInt(x)) {
				result = Math.min(min, Integer.parseInt(num));
				if (Integer.parseInt(num) < min) {
					min = Integer.parseInt(num);
				}
			}
			
			return;
		}
		
		for (int i = 0; i < x.length(); i++) {
			if (selected[i]) continue;
			
			ans[cnt] = nums[i];
			
			selected[i] = true;
			
			calculation(cnt + 1);
			selected[i] = false;
		}
		
		
	}

}
