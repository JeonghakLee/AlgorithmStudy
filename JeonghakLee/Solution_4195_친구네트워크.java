package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_4195_친구네트워크 {

	static int[] parents;
	static Set<Integer> people;
	static Map<String, Integer> nameId;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			nameId = new HashMap<>();
			
			int F = Integer.parseInt(br.readLine());
			makeSet(F);
			
			int id = 1;

			for (int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String p1 = st.nextToken();
				String p2 = st.nextToken();

				if (!nameId.containsKey(p1))
					nameId.put(p1, id++);
				if (!nameId.containsKey(p2))
					nameId.put(p2, id++);

				union(nameId.get(p1), nameId.get(p2));

				result.append((-parents[find(nameId.get(p1))]) + "\n");
			}
		}
		System.out.println(result.toString());
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);

		if (pa == pb)
			return;

		parents[Math.min(pa, pb)] += parents[Math.max(pa, pb)];
		parents[Math.max(pa, pb)] = Math.min(pa, pb);
	}

	private static int find(int a) {
		// parents의 값이 음수면 자기 자신이 대표 값
		if (parents[a] < 0) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	private static void makeSet(int n) {
		parents = new int[n * 2 + 1];

		for (int i = 1; i < n * 2 + 1; i++) {
			parents[i] = -1;
		}

	}

}
