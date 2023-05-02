package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_입국심사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] judge = new int[N];
		for (int i = 0; i < N; i++)
			judge[i] = Integer.parseInt(br.readLine());

		// 이분 탐색
		Arrays.sort(judge);
		long start = 0, end = (long) Math.pow(10, 18), mid = 0;

		while (start < end) {
			mid = (start + end) / 2;
			if (getPassedCnt(judge, mid, M) < M) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		System.out.println(end);
	}

	private static long getPassedCnt(int[] judge, long time, int M) {
		long result = 0;
		for (int i = 0; i < judge.length; i++) {
			result += time / judge[i];
			if (result > M)
				break;
		}
		return result;
	}

}
