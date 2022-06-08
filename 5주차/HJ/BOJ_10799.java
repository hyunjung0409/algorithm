//실버3
import java.io.*;
import java.util.*;

public class BOJ_10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Stack<String> stack = new Stack<>();
		int sum = 0;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '(') {
				stack.push("(");
			}else {
				stack.pop();
                //레이저가 아닌 경우 -> 잘리고 남은 막대 한 조각
				if(input.charAt(i-1) == ')') {
					sum+=1;
				}
                //레이저인 경우 -> 잘려진 모든 조각
                else {
					sum += stack.size();
				}
			}
		}
					
		System.out.println(sum);
	}

}
