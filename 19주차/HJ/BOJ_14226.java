import java.io.*;
import java.util.*;

public class BOJ_14226 {
  static int S;
  static boolean[][] visited;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    S = Integer.parseInt(br.readLine());
    visited = new boolean[1001][1001]; // visited[클립보드][화면]
    System.out.println(bfs());
  }

  static class Emoticon {
    int clipboard, screen, cnt;

    public Emoticon(int clipboard, int screen, int cnt) {
      this.clipboard = clipboard;
      this.screen = screen;
      this.cnt = cnt;
    }
  }

  private static int bfs() {
    Queue<Emoticon> queue = new LinkedList<>();
    visited[0][1] = true;
    queue.add(new Emoticon(0, 1, 0));

    while (!queue.isEmpty()) {

      Emoticon cur = queue.remove();

      if (cur.screen == S) {
        return cur.cnt;
      }

      // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
      if (!visited[cur.screen][cur.screen]) {
        visited[cur.screen][cur.screen] = true;
        queue.add(new Emoticon(cur.screen, cur.screen, cur.cnt + 1));
      }

      // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
      // 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다.
      if (cur.clipboard != 0 && cur.clipboard + cur.screen <= S
          && !visited[cur.clipboard][cur.clipboard + cur.screen]) {
        visited[cur.clipboard][cur.clipboard + cur.screen] = true;
        queue.add(new Emoticon(cur.clipboard, cur.clipboard + cur.screen, cur.cnt + 1));
      }

      // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
      if (cur.screen > 0 && !visited[cur.clipboard][cur.screen - 1]) {
        visited[cur.clipboard][cur.screen - 1] = true;
        queue.add(new Emoticon(cur.clipboard, cur.screen - 1, cur.cnt + 1));
      }

    }

    return -1;

  }

}
