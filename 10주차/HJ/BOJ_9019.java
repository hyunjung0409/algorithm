import java.io.*;
import java.util.*;

public class BOJ_9019 {

  static int T, A, B, max = 10000; //테스트 케이스, 레지스터의 초기 값, 최종 값, 최대값
  static boolean[] visited;
  static String result;

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while(T-- > 0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      visited = new boolean[max];

      bfs(A);
      sb.append(result+"\n");
    }
    System.out.println(sb.toString());
  }

  static class Point{
    int n; //
    String cmd;
    
    public Point(int n, String cmd){
      this.n = n; //결과 값
      this.cmd = cmd; //명령어
    } 
  }

  private static void bfs(int n){
    //큐 생성 -> 초기값 입력
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(n, ""));
    //초기값 방문 처리
    visited[n] = true;

    //와일문 -> 큐 remove해서 현재값
    while(!queue.isEmpty()){
      Point cur = queue.remove();
      int cn = cur.n;
      String ccmd = cur.cmd;

      //종료조건
      if(cn == B){
        result = ccmd;
        return;
      }

      //DSLR 명령에 따라 처리 (방문하지 않은 숫자 -> 방문처리 -> 큐에 add)
      int d = (cn*2) % 10000;
      if( visited[d] == false){
        visited[d] = true;
        queue.add(new Point(d, ccmd+"D"));
      }

      int s = (cn==0)? 9999 : cn-1;
      if( visited[s] == false){
        visited[s] = true;
        queue.add(new Point(s, ccmd+"S"));
      }

      int l = (cn%1000)*10 + (cn/1000);
      if(visited[l] == false){
        visited[l] = true;
        queue.add(new Point(l, ccmd+"L"));
      }

      int r = (cn/10) + (cn%10)*1000;
      if(visited[r] == false){
        visited[r] = true;
        queue.add(new Point(r, ccmd+"R"));
      }
    }
  }
}
