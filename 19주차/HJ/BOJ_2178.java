import java.io.*;
import java.util.*;

public class BOJ_2178 {
  static int N, M;
  static int[][] map;
  static boolean[][] visited;
  static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        // 1이면 이동 가능, 0은 벽으로 이동 불가능
        map[i][j] = str.charAt(j) - '0';
      }
    }

    visited = new boolean[N][M];
    visited[0][0] = true; // 방문처리
    System.out.println(bfs(0, 0, 1)); // 시작위치 포함으로 cnt 1부터 시작
  }

  static class Point {
    int r, c, cnt;

    public Point(int r, int c, int cnt) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
    }
  }

  private static int bfs(int r, int c, int cnt) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(r, c, cnt));

    while (!queue.isEmpty()) {
      Point cur = queue.remove();

      // 종료 조건 -> 도착점 도착
      if (cur.r == N - 1 && cur.c == M - 1) {
        return cur.cnt;
      }

      // 사방탐색
      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        // 범위 안에 있으면서 방문하지 않고 벽이 아닌 곳
        if (nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc] != true && map[nr][nc] != 0) {
          visited[nr][nc] = true;
          queue.add(new Point(nr, nc, cur.cnt + 1));
        }
      }
    }

    return -1;
  }

}