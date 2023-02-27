import java.io.*;
import java.util.*;

public class BOJ_10830 {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        long B = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                A[i][j] %= 1000;
            }
        }

        int[][] result = power(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int[][] power(int[][] A, long exponent){
        //지수가 1일 경우, 행렬 A 리턴
        if(exponent == 1){
            return A;
        }

        //지수가 1이 아닌 경우
        int[][] temp = new int[N][N];
        //지수/2 만큼 행렬 A 거듭제곱
        temp = power(A, exponent/2);
        //거듭제곱한 행렬을 서로 곱한다
        temp = multiple(temp, temp);

        //지수가 홀수인 경우, 한번 더 곱해준다
        if(exponent%2 == 1){
            temp = multiple(temp, A);
        }
        
        return temp; 
    }
    

    public static int[][] multiple(int[][] arr1, int[][] arr2) {
        int[][] temp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += arr1[i][k] * arr2[k][j]; //행렬 제곱
                    temp[i][j] %= 1000; //원소 1,000으로 나눈 나머지
                }
            }
        }

        return temp;
    }

}
