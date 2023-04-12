package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2341 {
	static int[] sequence;
	static int[][][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sequence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		memo = new int[sequence.length - 1][5][5];

		int minCost = dfs(0, 0, 0);

		System.out.println(minCost);
	}

	private static int dfs(int curr, int left, int right) {
		if (sequence[curr] == 0)
			return 0;

		if (memo[curr][left][right] != 0)
			return memo[curr][left][right];

		int moveLeft = dfs(curr + 1, sequence[curr], right) + getCost(left, sequence[curr]);
		int moveRight = dfs(curr + 1, left, sequence[curr]) + getCost(right, sequence[curr]);

		memo[curr][left][right] = Math.min(moveLeft, moveRight);

		return memo[curr][left][right];
	}

	private static int getCost(int u, int v) {
		if (u == 0) {
			return 2;
		}
		if (u == v) {
			return 1;
		}
		if (u - 1 == v || u + 1 == v) {
			return 3;
		}
		return 4;
	}
}
