// BOJ/실버3/괄호 끼워넣기/20분

import java.io.*;
import java.util.*;

public class BOJ_11899 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<>();
		
		String S = br.readLine();
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '(') {
				st.add('(');
			}else if(S.charAt(i) == ')'){
				if(!st.isEmpty() && st.peek() == '(') {
					st.pop();
				}else {
					st.add(')');
				}
			}
			
		}
		System.out.println(st.size());
	}

}