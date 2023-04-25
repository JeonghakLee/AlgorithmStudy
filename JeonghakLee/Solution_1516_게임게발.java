package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1516_게임게발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer>[] adjList = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		int[] times = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			times[i] = time;

			int v = Integer.parseInt(st.nextToken());
			while (v != -1) {
				adjList[v].add(i);
				indegree[i]++;
				v = Integer.parseInt(st.nextToken());
			}
		}

		int[] result = topologySort(N, adjList, indegree, times);

		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= N; i++)
			answer.append(result[i] + "\n");

		System.out.println(answer);
	}

	private static int[] topologySort(int N, List<Integer>[] adjList, int[] indegree, int[] times) {
		Queue<Integer> queue = new ArrayDeque<>();
		int[] result = Arrays.copyOf(times, N + 1);

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int next : adjList[curr]) {
				result[next] = Math.max(result[next], result[curr] + times[next]);

				indegree[next]--;

				if (indegree[next] == 0)
					queue.offer(next);
			}
		}

		return result;
	}
}