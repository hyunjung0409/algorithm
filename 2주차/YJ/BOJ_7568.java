package 알고리즘스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] info = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			String num = br.readLine();
			String[] nums = num.split(" ");
			info[i][0] = Integer.parseInt(nums[0]);
			info[i][1] = Integer.parseInt(nums[1]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int k = 1;
			for (int j = 0; j < N; j++) {
				if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) { //자신보다 덩치가 크면 k 증가
					k++;
				}
			}
			sb.append(k + " ");
		}
		
		System.out.println(sb);
	}

}
