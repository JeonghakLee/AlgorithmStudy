package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_16936_나3곱2 {

	static long[] answer;
	static int N;
	static Set<Long> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<Long> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}

		answer = new long[N];

		set = new HashSet<Long>(list);

		for (int i = 0; i < N; i++) {
			answer[0] = list.get(i);
			if (isPossible(list.get(i), 1))
				break;
		}

	}

	private static boolean isPossible(long x, int cnt) {

		if (cnt == N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(answer[i] + " ");
			}
			
			System.out.println(sb.toString().trim());
			System.exit(0);
			return true;
		}

		if (x % 3 == 0 && set.contains(x / 3)) {
			answer[cnt] = x / 3;
			isPossible(x / 3, cnt + 1);
		}

		if (set.contains(x * 2)) {
			answer[cnt] = x * 2;
			isPossible(x * 2, cnt + 1);
		}

		return false;
	}
}
