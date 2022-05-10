import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870_피보나치_수5 {

	private static int fibonacci(int n) {
		
		if(n == 1) return 1;
		if(n<=0) return 0;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacci(n));

	}

}
