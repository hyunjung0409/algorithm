import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9934 {
	
	static int K;
	static int[] input;
	static StringBuilder[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		
		K = Integer.parseInt(br.readLine()); //완전 이진 트리 depth
		
		int size = (int)Math.pow(2, K)-1; //완전 이진 트리 노드 총 개수
		input = new int[size]; //노드 입력받을 배열 (중위순회)
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new StringBuilder[K];
		for (int i = 0; i < K; i++) {
			result[i] = new StringBuilder();
		}
		
		tree(0, input.length-1, 0); //재귀 실행
		
		for (int i = 0; i < K; i++) {
			System.out.println(result[i].toString());
		}
		
	}
	
	private static void tree(int start, int end, int depth) {
		if(depth == K)
			return;

		int middle = (start + end) / 2; 
		
		result[depth].append(input[middle]+ " "); //중간 값이 루트 노드
		
		tree(start, middle-1, depth+1); //left
		tree(middle+1, end, depth+1); //right
	}
}