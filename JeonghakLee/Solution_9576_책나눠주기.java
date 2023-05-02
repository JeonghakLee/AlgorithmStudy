package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_9576_책나눠주기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			});

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				pq.offer(new int[] { a, b });
			}

			int answer = 0;
			boolean[] visit = new boolean[N + 1];

			while (!pq.isEmpty()) {
				int[] peek = pq.poll();

				for (int i = peek[0]; i <= peek[1]; i++) {
					if (!visit[i]) {
						visit[i] = true;
						answer++;
						break;
					}
				}
			}

			result.append(answer + "\n");
		}

		System.out.println(result);
	}
}
