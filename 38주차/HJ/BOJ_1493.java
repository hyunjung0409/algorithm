import java.io.*;
import java.util.*;

public class BOJ_1493 {
    
    static long fill=0, cnt=0; //이전에 사용된 큐브의 개수, 모두 채워진 큐브의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long l = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        long[] cube = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cube[Integer.parseInt(st.nextToken())] = Long.parseLong(st.nextToken());
        }

        long newSize = 1L << N-1; //비트 연산자로 제곱
        for (int i = N-1; i >=0 ; i--) {
            fill *= 8; //8개씩 분할됨

            //rest = 현재 큐브 사이즈로 채울 수 있는 수 - 사용된 큐브의 개수
            long rest = (l/newSize) * (w/newSize) * (h/newSize) - fill;
            //가지고 있는 큐브 개수만큼 사용
            rest = Math.min(cube[i], rest);

            cnt += rest;
            fill += rest;
            newSize >>= 1L;
        }

        if(fill == l * w * h)
            System.out.println(cnt);
        else
            System.out.println(-1);
    }
    
}
