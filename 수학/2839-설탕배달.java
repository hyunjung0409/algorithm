import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 설탕배달2839 {
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		int num = Integer.parseInt(N);
		int bag = 0;

		//거스름돈과 비슷하게 생각. 
		//최소한의 봉지를 사용해야하므로 3이 아닌 5로 나누기를 시도 후, 안 나눠지면 3을 빼는 반복형식
		while(true) {
			if (num % 5 == 0) {
				System.out.println(num / 5 + bag);
				break;
			}
			else if(num < 0) {
				System.out.println(-1);
				break;
			}
			num -= 3;
			bag++;
		}
		
		
		
//		calculation(Integer.parseInt(N), bag);
//		System.out.println(ans);

	}

    //재귀형식으로 풀었으나 시간초과(비효율적)
	private static void calculation(int N, int bag) {
		if (N == 0) {
			if (ans > bag) {
				ans = bag;
			}
			return;
		}
		
		if (N % 3 != 0 && N % 5 != 0) {
			if ((N - 5) % 5 == 0 || (N - 5) % 3 == 0) {
				calculation(N - 5, bag + 1);
			}
			else if ((N - 5) % 3 == 0 || (N - 5) % 3 == 0) {
				calculation(N - 3, bag + 1);
			}
			else {
				ans = -1;
				return;
			}
		}
		
		if (N % 5 == 0) {
			calculation(N - 5, bag + 1);
		}
		
		if (N % 3 == 0) {
			calculation(N - 3, bag + 1);
		}
	}

}
