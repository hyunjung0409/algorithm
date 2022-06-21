// BOJ/실버2/한 줄로 서기/50분

import java.io.*;
import java.util.*;

public class BOJ_1138 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int [n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> dq = new LinkedList<>();
		Deque<Integer> temp = new LinkedList<>();
		
		for (int i = n; i > 0; i--) {
			if(arr[i] == 0) {
				dq.addFirst(i);
			}else {
				if(arr[i] == dq.size()) {
					dq.addLast(i);
				}else {
					while(arr[i] != dq.size()) {
						temp.addFirst(dq.removeLast());
					}
					//arr[i] == dq.size()
					dq.addLast(i);
					while(temp.size() != 0) {
						dq.addLast(temp.removeFirst());
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(dq.removeFirst());
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

}
