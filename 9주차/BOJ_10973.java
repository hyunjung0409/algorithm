import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_10973 {
	static int N;
	static int[] nums, ans;
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		String[] nums2 = new String[N];
		
		String number = br.readLine();
		nums2 = number.split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(nums2[i]);
		}
		
		if (permutation()) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
		}
		else {
			System.out.println(-1);
		}
	}

	private static boolean permutation() {
		int i = nums.length - 1;
		
		while(i > 0 && nums[i] > nums[i - 1]) {
			i--;
		}
		
		if (i == 0) {
			return false;
		}
		
		int j = nums.length - 1;
		
		while(nums[i - 1] < nums[j]) {
			j--;
		}
		
		swap(i - 1, j);
		
		j = nums.length - 1;
		
		while(i < j) {
			swap(i, j);
			i++;
			j--;
		}
		
		return true;
		
	}

	private static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}

}
