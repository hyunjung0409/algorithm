import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_11899 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String bracket = br.readLine();
		int cnt = 0;
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < bracket.length(); i++) {
			if (bracket.charAt(i) == '(') {
				stack.push(bracket.charAt(i));
			}
			else if (bracket.charAt(i) == ')') {
				if (stack.isEmpty()) {
					cnt++;
				}
				else {
					stack.pop();
				}
			}
		}
		
		if (stack.size() != 0) {
			cnt += stack.size();
		}
		
		System.out.println(cnt);
	
		
	}

}
