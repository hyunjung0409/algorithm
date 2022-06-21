// BOJ/실버3/크면서 작은 수/1시간

import java.io.*;
import java.util.*;

public class BOJ_2992 {

	static ArrayList<Integer> list = new ArrayList<>();
	static String X;
	static int x;
	static char[] input, result;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = br.readLine();
		x = Integer.parseInt(X);
		input = X.toCharArray();
		result = new char[X.length()];
		isSelected = new boolean[X.length()];

		perm(0);
		Collections.sort(list);
		
//		System.out.println(list);
//		System.out.println(list.get(0));
		
		if(list.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(list.get(0));
		}
		
	}
	
	private static void perm(int cnt) {
		if(cnt == X.length()) {
			String temp = "";
			for (int i = 0; i < result.length; i++) {
				temp += result[i];
			}
			
			int swapNum = Integer.parseInt(temp);
			if(swapNum > x) {
				list.add(swapNum);				
			}
		}
		
		for(int i = 0; i < X.length(); i++) {
			if(isSelected[i])
				continue;
			
			result[cnt] = input[i];
			isSelected[i] = true;
			
			perm(cnt+1);
			isSelected[i] = false;
		}
	}

}
