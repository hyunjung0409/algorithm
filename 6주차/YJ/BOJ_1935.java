import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String formula = br.readLine();
		
		double[] nums = new double[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		for (int i = 0; i < formula.length(); i++) {
			if ('A' <= formula.charAt(i) && 'Z' >= formula.charAt(i)) {
				stack.push(nums[formula.charAt(i) - 'A']); //'A'를 빼면 인덱스값으로 'A'는 0, 'B'는 1 ... 이렇게 가니까
				//System.out.println(formula.charAt(i) - 'A');
			}
			else {
				double result = 0;
				if (!stack.isEmpty()) {
					double first = stack.pop();
					double second = stack.pop();
					
					switch(formula.charAt(i)) {
					case '+':
						result = second + first;
						stack.push(result);
						continue;
					case '-':
						result = second - first;
						stack.push(result);
						continue;
					case '*':
						result = second * first;
						stack.push(result);
						continue;
					case '/':
						result = second / first;
						stack.push(result);
						continue;
					}
				}
			}
		}
		
		System.out.printf("%.2f", stack.pop());

	}

}
