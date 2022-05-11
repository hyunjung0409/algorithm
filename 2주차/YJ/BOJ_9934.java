import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_9934 {
	static StringBuilder[] sb;
	static int K;
	static String[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		int size = (int)Math.pow(2, K) - 1; //이진트리 노드 개수

		num = br.readLine().split(" ");
		
		sb = new StringBuilder[K];
		
		for (int i = 0; i < K; i++) {
			sb[i] = new StringBuilder();
		}
		
		binary(0, size -1, 0);
		
		for (int i = 0; i < K; i++) {
			System.out.println(sb[i].toString());
		}
		

	}

	private static void binary(int start, int end, int depth) {
		if (depth == K) {
			
			return;
		}
		
		int middle = (start + end) / 2; //중간 위치
		
		sb[depth].append(num[middle] + " "); //중간값을 항상 먼저 출력
		
		binary(start, middle - 1, depth + 1); //앞쪽에서 중간값 찾기
		
		binary(middle + 1, end, depth + 1); //뒷쪽에서 중간값 찾기
		
		
	}

}
