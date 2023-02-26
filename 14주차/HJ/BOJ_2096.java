import java.io.*;
import java.util.*;

public class BOJ_2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
			
		int[] memoMax = new int[3];
		int[] memoMin = new int[3];
		
		//초기값 메모이제이션
		StringTokenizer st = new StringTokenizer(br.readLine());
		memoMax[0] = memoMin[0] = Integer.parseInt(st.nextToken());
		memoMax[1] = memoMin[1] = Integer.parseInt(st.nextToken());
		memoMax[2] = memoMin[2] = Integer.parseInt(st.nextToken());
		
		
		//n-1개 줄만큼 반복
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			//3개의 숫자
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			
			//이전 줄의 최대, 최소값을 저장할 배열
			int[] tmp = new int[3];
			
			tmp[0] = Math.max(memoMax[0], memoMax[1]);
			tmp[1] = Math.max(Math.max(memoMax[0], memoMax[1]), memoMax[2]);
			tmp[2] = Math.max(memoMax[1], memoMax[2]);
			
			//최대값 메모
			memoMax[0] = tmp[0] + num1; 
			memoMax[1] = tmp[1] + num2;
			memoMax[2] = tmp[2] + num3; 
			
			tmp[0] = Math.min(memoMin[0], memoMin[1]);
			tmp[1] = Math.min(Math.min(memoMin[0], memoMin[1]), memoMin[2]);
			tmp[2] = Math.min(memoMin[1], memoMin[2]);
			
			//최소값 메모
			memoMin[0] = tmp[0] + num1; 
			memoMin[1] = tmp[1] + num2;
			memoMin[2] = tmp[2] + num3; 
		}
		
		//최대, 최소 구하기
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, memoMax[i]);
			min = Math.min(min, memoMin[i]);
		}
		
		System.out.println(max + " " + min);
	}

}
