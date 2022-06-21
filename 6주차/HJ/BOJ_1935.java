//백준 후위 표기식2 실버3 45분
import java.io.*;
import java.util.*;

public class BOJ_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		HashMap<Character, Integer> map = new HashMap<>();
		char ch = 'A';
		for (int i = 0; i < N; i++) {
			map.put(ch++, Integer.parseInt(br.readLine()));
		}
		
		Stack<Double> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			
			if( tmp>= 'A' && tmp <='Z') {
				st.push((double) map.get(tmp));
			}
			else {
				double second = st.pop();
				double first = st.pop();
				double result = 0;
				
				switch(tmp) {
				case '+':
					result = first + second;
					break;
				
				case '-':
					result = first - second;
					break;
					
				case '*':
					result = first * second;
					break;
					
				case '/':
					result = first / second;
					break;
				}
			
				st.push(result);
			}
		}
//		System.out.printf("%.2f", st.pop());
		System.out.println(String.format("%.2f", st.pop()));
	}
	
}