import java.io.*;
import java.util.*;

public class BOJ_5547 {
	
	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[W][H];
		visited = new boolean[W][H];
		
	}
}
