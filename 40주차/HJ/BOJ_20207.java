import java.io.*;
import java.util.*;

/**
 * BOJ_20207
 */
public class BOJ_20207 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days[] = new int[367];
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int start = 0, end = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                days[j]++;
            }
        }

        int result = 0, from = 0, to = 0, max = 0;
        for (int i = 1; i <= 365; i++) {
            if(days[i] > 0 && days[i-1] == 0) 
            {
                from = i;
                // System.out.println("from: " + from);
            }
            if(days[i] > max) 
            {
                max = days[i];
                // System.out.println("max: " + max);
            }
            if(days[i] > 0 && days[i+1] == 0){
                to = i;
                // System.out.println("to: " + to);
                result += (to - from + 1) * max;
                // System.out.println("result: " + result);
                max = 0;
            }
        }

        System.out.println(result);
    }
}