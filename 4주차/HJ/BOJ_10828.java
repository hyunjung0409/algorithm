import java.io.*;
import java.util.*;

public class BOJ_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			switch(input) {
			case "push" :
				stack.push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop" :
				if(!stack.empty()) {
					sb.append(stack.pop()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
				
			case "size" :
				sb.append(stack.size()).append("\n");
				break;
				
			case "empty" :
				if(stack.empty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
				
			case "top" :
				if(!stack.empty()) {
					sb.append(stack.peek()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
		
	}

}
