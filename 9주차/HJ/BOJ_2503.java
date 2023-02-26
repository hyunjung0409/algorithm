import java.io.*;
import java.util.*;

public class BOJ_2503 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		String[] num = new String[N]; //세 자리 수
		int[][] info = new int[N][2]; //[0]:스트라이크 [1]:볼
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = st.nextToken();
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		for (int i = 1; i <= 9; i++) { // 첫째자리
			for (int j = 1; j <= 9; j++) { // 둘째자리
				if(i!=j) {
					for (int k = 1; k <= 9; k++) { // 셋째자리
						if(k!=i&&k!=j) {
							boolean flag = true;
							for (int n = 0; n < N; n++) { 
								int strike = 0;
								int ball = 0;
								String str = num[n];
								if(str.charAt(0)-'0'==i) strike++;
								if(str.charAt(1)-'0'==j) strike++;
								if(str.charAt(2)-'0'==k) strike++;
								if(str.charAt(0)-'0'==j||str.charAt(0)-'0'==k) ball++;
								if(str.charAt(1)-'0'==i||str.charAt(1)-'0'==k) ball++;
								if(str.charAt(2)-'0'==i||str.charAt(2)-'0'==j) ball++;
								if(info[n][0]!=strike||info[n][1]!=ball) {
									flag = false;
									break;
								} 
							}
							if(flag) ans++;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

}