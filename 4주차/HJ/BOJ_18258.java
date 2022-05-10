import java.io.*;
import java.util.*;

public class BOJ_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		while(N-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push":
				dq.add(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
				if(!dq.isEmpty()) {
					sb.append(dq.poll()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
				
			case "size":
				sb.append(dq.size()).append("\n");
				break;
				
			case "empty":
				if(dq.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
				
			case "front":
				if(!dq.isEmpty()) {
					sb.append(dq.peek()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			case "back":
				if(!dq.isEmpty()) {
					sb.append(dq.peekLast()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}

}