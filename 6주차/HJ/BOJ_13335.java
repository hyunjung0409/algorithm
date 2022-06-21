//백준 트럭 실버1
import java.io.*;
import java.util.*;


public class BOJ_13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //다리 건너는 트럭 수
		int w = Integer.parseInt(st.nextToken()); //다리 길이
		int l = Integer.parseInt(st.nextToken()); //다리 최대하중
		
		Queue<Integer> trucks = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> bridge = new LinkedList<>();
		for (int i = 0; i < w; i++) { //다리 길이만큼 0을 넣어준다.
			bridge.add(0);
		}
		
		int time = 0;
		int sum = 0;
		while(!bridge.isEmpty()) {
			time++;
			sum -= bridge.poll();
			if(!trucks.isEmpty()) {
				if(trucks.peek()+sum <= l) { //다리 무게 합이 최대하중보다 작으면
					sum += trucks.peek(); //다리 무게 합에 트럭 무게를 더해주고
					bridge.add(trucks.poll()); //다리 큐에 넣어준다.
				}else { //다리 무게 합이 최대하중보다 크면
					bridge.add(0); //지나갈 수 없으므로 다리 큐에 0을 넣어준다.
				}
			}
		}
		System.out.println(time);
		
	}

}
