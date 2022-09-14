import java.io.*;
import java.util.*;

public class BOJ_1912 {
	static int n, max;
	static int[] arr, memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = arr[0]; //max값 초기화

		memo = new int[n]; 	//메모이제이션 배열 -> 현재 인덱스까지의 합 중 최대합을 저장.
		memo[0] = arr[0]; 	//초기화
		for (int i = 1; i < n; i++) {
			//이전 메모된 값에 현재값을 더한 값, 현재값을 비교해 최대값을 메모한다.
			memo[i] = Math.max(memo[i-1] + arr[i], arr[i]);
			//최대값 갱신
			max = Math.max(memo[i], max);
		}
		
		System.out.println(max);
	}

}