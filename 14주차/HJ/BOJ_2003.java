import java.io.*;
import java.util.*;

public class BOJ_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
    //n(수열 원소의 개수), m(수열 부분 구간 합) 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		//n개의 수열을 배열로 입력
    int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
    //부분 구간 합을 구하기 위해 start, end 인덱스 사용(투 포인터)
    //cnt: 부분 구간 합을 만족시키는 경우의 수 카운트
    //sum: start, end 사이의 부분 구간 합
		int start = 0, end = 0, cnt = 0, sum = 0;
		

    //sum이 m보다 작으면, end를 다음 인덱스로 이동시켜 해당 원소를 sum에 더한다.
    //sum이 m과 같거나 커지면, start를 다음 인덱스로 이동키셔 해당 원소를 sum에서 빼준다.
    //sum이 m이 되면 cnt를 증가한다.
    //위 과정을 end 인덱스가 n이 될 때까지 반복한다. 
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
		
    //경우의 수 출력
		System.out.println(cnt);
	}

}
