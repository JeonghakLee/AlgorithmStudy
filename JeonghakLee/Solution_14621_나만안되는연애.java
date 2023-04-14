package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_14621_나만안되는연애 {
	static class Edge {
		int u, v, w;

		public Edge(int u, int v, int w) {
			super();
			this.u = u;
			this.v = v;
			this.w = w;
		}

	}

	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] isMan = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			isMan[i] = st.nextToken().equals("M") ? true : false;
		}

		ArrayList<Edge> edgeList = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(u, v, w));
		}

		int answer = 0, cnt = 0;

		// 크루스칼 알고리즘
		Collections.sort(edgeList, (e1, e2) -> e1.w - e2.w); // 간선 정렬
		makeSet(N);

		for (Edge edge : edgeList) {
			if (find(edge.u) != find(edge.v) && isMan[edge.u] != isMan[edge.v]) {
				union(edge.u, edge.v);
				answer += edge.w;
				cnt++;
			}
		}

		if (cnt < N - 1)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (b > a) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	private static void makeSet(int N) {
		parents = new int[N + 1];
		for (int i = 1; i < N; i++) {
			parents[i] = i;
		}
	}

}
