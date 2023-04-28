import java.io.*;
import java.util.*;

public class BOJ_14503 {

    static int N, M, r, c, d, cnt, map[][];
    // d: 0 - 북, 1 - 동, 2 - 남, 3 - 서
    static int dr[] = { -1, 0, 1, 0 };
    static int dc[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        dfs(r, c, d);
        System.out.println(cnt);
    }

    private static void dfs(int r, int c, int d) {
        // 벽일 경우
        if (map[r][c] == 1)
            return;

        // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if (map[r][c] == 0) {
            // 청소 완료 칸은 2로 체크
            map[r][c] = 2;
            cnt++;
        }

        // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
        for (int i = 0; i < 4; i++) {
            // 3-1. 반시계 방향으로 90도 회전한다.
            d = (d + 3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];
            // 청소 완료(2) 또는 벽(1)일 경우
            if (map[nr][nc] > 0)
                continue;
            // 청소하지 않은 공간이라면
            // 3-2. 그 방향으로 회전하고 한 칸 전진 -> 3-3. 1번부터 재진행
            dfs(nr, nc, d);
            return;
        }

        // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
        // 2-1. 바라보는 방향 유지 -> 한 칸 후진 -> 1번부터 재진행
        dfs(r - dr[d], c - dc[d], d);
        // 2-2. 바라보는 방향 뒤쪽 칸이 벽으로 후진할 수 없으면 작동 멈춤
        return;
    }
    // 5 5
    // 2 1 0
    // 1 1 1 1 1
    // 1 0 1 0 1
    // 1 0 1 0 1
    // 1 0 0 0 1
    // 1 1 1 1 1
    // >> 6

}