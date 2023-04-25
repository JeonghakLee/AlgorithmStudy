package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2141_우체국 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] town = new int[N][2];
		long population = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			population += A;
			town[i] = new int[] { X, A };
		}

		Arrays.sort(town, (o1, o2) -> o1[0] - o2[0]);

		long curr = 0;
		int answer = 0;

		for (int i = 0; i < N; i++) {
			curr += town[i][1];
			if (curr >= population / 2) {
				answer = town[i][0];
				break;
			}
		}

		System.out.println(answer);
	}
}
