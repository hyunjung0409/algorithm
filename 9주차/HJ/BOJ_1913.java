import java.io.*;
import java.util.*;

public class BOJ_1913 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        
        int num = 1;
        int r = N/2, c = N/2;
        
        int distance = 1;
        while(true){
            for(int i=0; i<distance; i++){
                arr[r--][c] = num++;
            }
            if(num-1 == N*N) break;
            for(int i=0; i<distance; i++){
                arr[r][c++] = num++;
            }
            distance++;
            for(int i=0; i<distance; i++){
                arr[r++][c] = num++;
            }
            for(int i=0; i<distance; i++){
                arr[r][c--] = num++;
            }
            distance++;
        }
        
        StringBuilder sb = new StringBuilder();
        int idx_r = 0, idx_c = 0;
		for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(arr[i][j]).append(" ");
                if(arr[i][j] == target){
                    idx_r = i+1;
                    idx_c = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(idx_r).append(" ").append(idx_c);
        
        System.out.println(sb.toString());
	}
}