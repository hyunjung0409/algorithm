import java.io.*;
import java.util.*;

/**
 * BOJ_20207
 */
public class BOJ_20207 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days[] = new int[366];
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int start = 0, end = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            for (int j = start; j < end; j++) {
                days[j] += 1;
            }
        }

        int result = 0, length = 0, max = 0;
        for (int i = 1; i <= days.length; i++) {
            
        }
    }
}