// BOJ/실버1/괄호의 값/1시간/틀림

import java.io.*;
import java.util.*;

public class BOJ_2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Stack<Character> st = new Stack<>();
		
		int result = 0, tmp = 1;
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '(':
				st.push('(');
				tmp *= 2;
				break;

			case '[':
				st.push('[');
				tmp *= 3;
				break;

			case ')':
				if(st.isEmpty() || st.peek() != '(') {
					result = 0;
					break;
				}
				if(str.charAt(i-1) == '(') {
					result += tmp;
				}
				st.pop();
				tmp /= 2;
				break;
			
			case ']':
				if(st.isEmpty() || st.peek() != '[') {
					result = 0;
					break;
				}
				if(str.charAt(i-1) == '[') {
					result += tmp;
				}
				st.pop();
				tmp /= 3;
				break;
			}
		}
		System.out.println( st.isEmpty() == true ? result : 0);
	}

}
