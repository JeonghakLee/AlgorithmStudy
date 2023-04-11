package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_17255_N으로만들기 {

	static char[] nums;
	static int answer, numLen;
	static Set<String> promiseSet;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		nums = sc.nextLine().toCharArray();
		numLen = nums.length;
		promiseSet = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			dfs(i, i, nums[i] + "", nums[i] + "");
		}

		System.out.println(promiseSet.size());
	}

	private static void dfs(int l, int r, String curr, String sequence) {
		if (l == 0 && r == numLen - 1) {
			promiseSet.add(sequence);
			return;
		}

		if (0 <= l - 1) {
			String addLeft = nums[l - 1] + curr;
			dfs(l - 1, r, addLeft, sequence + addLeft);
		}

		if (r + 1 < numLen) {
			String addRight = curr + nums[r + 1];
			dfs(l, r + 1, addRight, sequence + addRight);
		}

	}

}
