import java.io.*;

public class BOJ_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int num_length = num.length();
        String[] octal = {"000", "001", "010", "011", "100", "101", "110", "111"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num_length; i++) {
            int temp = num.charAt(i) - '0'; //3 1 4
            if(i == 0 && temp < 4){ //0으로 시작하는 수
                if(temp < 2)
                    sb.append(octal[temp].substring(2)); //00 자르기
                else
                    sb.append(octal[temp].substring(1)); //0 자르기
            }
            else{
                sb.append(octal[temp]);
            }
        }
        System.out.println(sb.toString());
    }
}
