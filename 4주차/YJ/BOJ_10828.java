import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String order = br.readLine();

			if (order.contains("push")) {
				String[] num = order.split(" ");
				stack.push(Integer.parseInt(num[1]));
			}
			else if (order.equals("pop")) {
				if (!stack.isEmpty()) {
					System.out.println(stack.peek());
					stack.pop();
				}
				else {
					System.out.println(-1);
				}
			}
			else if (order.equals("size")) {
				System.out.println(stack.size());
			}
			else if (order.equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if (order.equals("top")) {
				if (!stack.isEmpty()) {
					System.out.println(stack.peek());
				}
				else {
					System.out.println(-1);
				}
			}
		}
		

	}

}
