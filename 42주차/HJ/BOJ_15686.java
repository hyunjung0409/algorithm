import java.io.*;
import java.util.*;

public class BOJ_15686 {

    static int N, M, map[][], chicken_cnt, comb[], result = Integer.MAX_VALUE;
    static ArrayList<Node> home = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) home.add(new Node(i, j));
                if(map[i][j] == 2){
                    chicken.add(new Node(i, j));
                    chicken_cnt++;
                }
            }
        }

        comb = new int[chicken_cnt];
        combination(0, 0);

        System.out.println(result);
    }

    private static void combination(int cnt, int start) {
        //폐업시키지 않을 치킨집(M)만큼 뽑아 조합 생성
        if(cnt == M){
            //이때
        }

        for (int i = start; i < chicken_cnt; i++) {
            comb[cnt] = i;
            combination(cnt+1, i+1);
        }
    }

    public static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}