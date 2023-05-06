import java.io.*;

public class BOJ_5582 {
  public static void main(String[] args) throws IOException {
    int N, M, max = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = new String(br.readLine());
    String str2 = new String(br.readLine());

    N = str1.length();
    M = str2.length();
    int[][] dp = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }

    System.out.println(max);
  }
}
