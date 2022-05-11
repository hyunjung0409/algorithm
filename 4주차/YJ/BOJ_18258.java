import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_18258 {

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int last = 0;
		
		for (int i = 0; i < n; i++) {
			String order = br.readLine();

			if (order.contains("push")) {
				String[] num = order.split(" ");
				queue.add(Integer.parseInt(num[1]));
				last = Integer.parseInt(num[1]);
			}
			else if (order.equals("pop")) {
				if (!queue.isEmpty()) {
					sb.append(queue.peek() + "\n");
					queue.remove();
				}
				else {
					sb.append(-1 + "\n");
				}
			}
			else if (order.equals("size")) {
				sb.append(queue.size() + "\n");	
			}
			else if (order.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1 + "\n");
				}
				else {
					sb.append(0 + "\n");
				}
			}
			else if (order.equals("front")) {
				if (!queue.isEmpty()) {
					sb.append(queue.peek() + "\n");
				}
				else {
					sb.append(-1 + "\n");
				}
			}
			else if (order.equals("back")) {
				if (!queue.isEmpty()) {
					sb.append(last + "\n");
				}
				else {
					sb.append(-1 + "\n");
				}
			}
		}
		
		System.out.println(sb);
		

	}

}
