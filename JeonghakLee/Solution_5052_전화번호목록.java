package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 2
3
911
97625999
91125426
5
113
12340
123440
12345
98346
 */
public class Solution_5052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] numbers = new String[N];
			boolean[] check = new boolean[11];
			Set<String>[] prefixes = new HashSet[10 + 1];

			for (int i = 0; i <= 10; i++) {
				prefixes[i] = new HashSet<>();
			}

			for (int i = 0; i < N; i++) {
				numbers[i] = br.readLine().trim();
				check[numbers[i].length()] = true;
				prefixes[numbers[i].length()].add(numbers[i]);
			}

			if (isPossible(prefixes, numbers, check)) {
				result.append("YES\n");
			} else {
				result.append("NO\n");
			}
		}

		System.out.println(result.toString());
	}

	private static boolean isPossible(Set<String>[] prefixes, String[] numbers, boolean[] check) {
		for (String number : numbers) {
			for (int i = 1; i <= 10; i++) {
				if (number.length() < i)
					break;
				if (check[i]) {
					String sub = number.substring(0, i);
					if (i != number.length() && prefixes[i].contains(sub))
						return false;
				}
			}
		}

		return true;
	}
}
