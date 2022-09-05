import java.io.*;
import java.util.*;

public class BOJ_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0, cnt = 0, sum = 0;
		
		while(true) {			
			if(sum >= m)
				sum -= arr[start++];
			else if(end == n)
				break;
			else
				sum += arr[end++];	
			
			if(sum == m)
				cnt++;
		}
		
		System.out.println(cnt);
	}

}
