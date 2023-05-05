package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1162_도로포장 {
	private static final long INF = Long.MAX_VALUE;

	static class Info implements Comparable<Info> {
		int v, k;
		long w;

		public Info(int v, int k, long w) {
			super();
			this.v = v;
			this.k = k;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return Long.compare(this.w, o.w);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<int[]>[] adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new int[] { v, w });
			adjList[v].add(new int[] { u, w });
		}

		long[][] D = new long[K + 1][N + 1];
		for (int i = 0; i < K + 1; i++) {
			Arrays.fill(D[i], INF);
		}

		long answer = dijkstra(N, K, adjList, D);
		System.out.println(answer);
	}

	private static long dijkstra(int N, int K, List<int[]>[] adjList, long[][] D) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.offer(new Info(1, 0, 0L));

		while (!pq.isEmpty()) {
			Info curr = pq.poll();
			if (curr.w > D[curr.k][curr.v])
				continue;

			for (int[] next : adjList[curr.v]) {
				// 현재 도로를 포장하지 않는 경우
				if (D[curr.k][next[0]] > curr.w + next[1]) {
					D[curr.k][next[0]] = curr.w + next[1];
					pq.offer(new Info(next[0], curr.k, D[curr.k][next[0]]));
				}
				// 현재 도로를 포장하는 경우
				if (curr.k + 1 <= K) {
					if (D[curr.k + 1][next[0]] > curr.w) {
						D[curr.k + 1][next[0]] = curr.w;
						pq.offer(new Info(next[0], curr.k + 1, D[curr.k + 1][next[0]]));
					}
				}
			}
		}

		long answer = INF;
		for (int i = 0; i <= K; i++) {
			answer = Math.min(answer, D[i][N]);
		}

		return answer;
	}
}
