import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_13335 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String string = br.readLine();
		String[] sentence = string.split(" ");
		int[] nums = new int[n + 1];
		int[] ans = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(sentence[i - 1]);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (nums[i] == 0 && ans[j] == 0) { //나보다 큰 사람 왼쪽에 다 있고, 해당 자리가 비어있으면
					ans[j] = i;
					break;
				}
				else if (ans[j] == 0) { //나보다 큰 사람이 아직 왼쪽에 더 있어야하는데 해당자리가 비어있으면 
					nums[i]--;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(ans[i] + " ");
		}

	}

}
