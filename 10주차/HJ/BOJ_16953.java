
// BOJ/실버2/16953/1시간
import java.io.*;
import java.util.*;

public class BOJ_16953 {

	static long A, B, min = Long.MAX_VALUE;
	static int max = 1000000000;

	public static void main(String[] args) throws IOException {
		// A, B 입력받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		// bfs -> 최소값 출력
		System.out.println(bfs(A));
	}

	static class Point {
		long n;
		int cnt; // 결과값, 연산횟수 카운트

		public Point(long n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}

	private static long bfs(long n) {
		// 큐 생성 -> 초기값 삽입
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(n, 1));

		// 와일문 -> 큐 remove -> 현재값 설정
		while (!queue.isEmpty()) {
			Point cur = queue.remove();
			long cn = cur.n;
			int ccnt = cur.cnt;

			// 종료조건 (현재값이 B -> 최소값 반환)
			if (cn == B) {
				min = Math.min(ccnt, min);
				return min;
			}

			if (cn * 2 > 0 && cn * 2 <= max)
				queue.add(new Point(cn * 2, ccnt + 1));

			if (cn * 10 + 1 > 0 && cn * 10 + 1 <= max)
				queue.add(new Point(cn * 10 + 1, ccnt + 1));
		}

		return -1L;
	}

}
