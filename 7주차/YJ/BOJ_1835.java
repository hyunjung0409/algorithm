import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;
public class BOJ_1835 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Deque<Integer> deque = new LinkedList<>();
		
		deque.add(n); //n을 먼저 삽입
		
		for (int i = n - 1; i >= 1; i--) { //n - 1부터 1까지 왼쪽에 삽입
			deque.addFirst(i);
			for (int j = 1; j <= i; j++) { //i번만큼 뒤에 값을 빼내어 왼쪽에 삽입(이 부분이 카드 1장 뒤로 보낸 다음 카드가 1, 카드 2장 뒤로 보낸다음 카드가 2 ... 이렇게 나오는 코드)
				deque.addFirst(deque.pollLast());
			}
		}
		
		for (int card : deque) {
			System.out.print(card + " ");
		}

	}

}
