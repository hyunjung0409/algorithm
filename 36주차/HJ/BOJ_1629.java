import java.io.*;
import java.util.*;

public class BOJ_1629 {
	
	public static long A, B, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(power(A, B));
	}
	
	public static long power(long base, long exponent) {
		//base: 밑, exponent: 지수
		
		//기저조건 - 지수가 1일 경우, 밑 % C를 리턴
		if(exponent == 1) {
			return base % C;
		}
		
		//지수 법칙 - 지수가 1이 될 때까지 지수를 반으로 나눈다
		long temp = power(base, exponent / 2);
		
		//지수가 홀수인 경우, 밑^1을 곱해준다
		if(exponent % 2 == 1) {
			return (temp * temp % C) * base % C;
		}
		
		//지수가 짝수인 경우
		return temp * temp % C;
	}

}
