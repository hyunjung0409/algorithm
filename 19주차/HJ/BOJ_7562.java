import java.io.*;
import java.util.*;

public class BOJ_7562 {
  static int tc, l, start_r, start_c, end_r, end_c;
  static int[][] map;
  static boolean[][] visited;
  static int[] dr = { 2, 1, -1, -2, -2, -1, 1, 2 };
  static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    tc = Integer.parseInt(br.readLine());

    for (int t = 0; t < tc; t++) {
      // input
      l = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      start_r = Integer.parseInt(st.nextToken());
      start_c = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      end_r = Integer.parseInt(st.nextToken());
      end_c = Integer.parseInt(st.nextToken());

      map = new int[l][l];
      visited = new boolean[l][l];
      // 방문처리
      visited[start_r][start_c] = true;

      sb.append(bfs(start_r, start_c, 0)).append("\n");
    }

    System.out.print(sb.toString());
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

      // 종료 조건
      if (cur.r == end_r && cur.c == end_c) {
        return cur.cnt;
      }

      // 팔방탐색
      for (int i = 0; i < 8; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        // 범위 안에 있으면서 방문하지 않은 곳
        if (nr >= 0 && nr < l && nc >= 0 && nc < l && visited[nr][nc] != true) {
          visited[nr][nc] = true; // 방문처리
          queue.add(new Point(nr, nc, cur.cnt + 1));
        }
      }

    }

    return -1;
  }

}