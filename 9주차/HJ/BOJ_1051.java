import java.io.*;
import java.util.*;

public class BOJ_1051 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        
        //숫자 배열 입력
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        
        //배열 탐색
        int ans, tmp = 0;
        int max = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                tmp = arr[i][j]; //기준점 (좌상)
                for(int k=j+1; k<M; k++){ // 행 검사
                    if(tmp == arr[i][k]){ 
                        for(int l=i+1; l<N; l++){ //열 검사
                            if(tmp == arr[l][j]){ 
                                if(tmp == arr[l][k]){
                                    if((l+1-i) == (k+1-j)){ //정사각형 검사
                                        ans = (l+1-i) * (k+1-j);
                                        if(max < ans){
                                            max = ans;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
        
	}
}