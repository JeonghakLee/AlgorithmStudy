package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2616_소형기관차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] passengers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int K = Integer.parseInt(br.readLine());

		// 누적합 구하기
		int[] cum_sum = Arrays.copyOf(passengers, N);
		for (int i = 1; i < N; i++) {
			cum_sum[i] += cum_sum[i - 1];
		}

		int[][] D = new int[4][N];

		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				if (j < K) {
					D[i][j] = cum_sum[j];
					continue;
				}
				D[i][j] = Math.max(D[i][j - 1], D[i - 1][j - K] + cum_sum[j] - cum_sum[j - K]);
			}
		}

		System.out.println(D[3][N - 1]);

	}
}