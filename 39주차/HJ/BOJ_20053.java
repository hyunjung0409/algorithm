import java.io.*;
import java.util.*;

public class BOJ_20053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int max = Collections.max(arr);
            int min = Collections.min(arr);
            sb.append(min + " " + max + "\n");
        }

        System.out.println(sb.toString());
    }
    
}

