//백준 실버4 카드 40분

import java.io.*;
import java.util.*;

public class BOJ_1835 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new LinkedList<>();
		
		dq.add(n);
		for (int i = n-1; i > 0; i--) {
			dq.addFirst(i);
			for (int j = 0; j < i; j++) {	
				dq.addFirst(dq.removeLast());
			}
		}
		
		for (int i = 0; i < n; i++) {
			sb.append(dq.removeFirst());
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
