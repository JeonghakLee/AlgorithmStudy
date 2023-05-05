package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_10653_마라톤2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] checkPoints = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			checkPoints[i] = new int[] { x, y };
		}

		int[][] DP = new int[K + 1][N];

		for (int k = 0; k <= K; k++) {
			for (int i = 1; i < N; i++) {
				if (i <= k)
					continue;

				int min = Integer.MAX_VALUE;
				for (int j = 0; j <= k; j++) {
					min = Math.min(min, DP[k - j][i - j - 1] + getDistance(checkPoints[i - j - 1], checkPoints[i]));
				}
				DP[k][i] = min;
			}
		}

		System.out.println(DP[K][N - 1]);
	}

	private static int getDistance(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}
}
