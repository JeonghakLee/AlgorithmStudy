package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_22942_데이터체커_개선 {

	static class Round {
		int r, x;

		public Round(int r, int x) {
			super();
			this.r = r;
			this.x = x;
		}

		public int right() {
			return x + r;
		}

		public int left() {
			return x - r;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Round[] rounds = new Round[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			rounds[i] = new Round(r, x);
		}

		Arrays.sort(rounds, (o1, o2) -> o1.x - o2.x);

		Stack<Round> stack = new Stack<>();
		stack.add(rounds[0]);

		for (int i = 1; i < N; i++) {

			// 현재 원에 포함되는 원들은 모두 pop
			while (!stack.isEmpty()) {
				int d = Math.abs(stack.peek().x - rounds[i].x);

				// 내접 혹은 외접 하는 경우
				if (Math.abs(stack.peek().r - rounds[i].r) < d && d < stack.peek().r + rounds[i].r) {
					System.out.println("NO");
					return;
				}
				// 두 점에서 만나는 경우
				if (Math.abs(stack.peek().r - rounds[i].r) == d || stack.peek().r + rounds[i].r == d) {
					System.out.println("NO");
					return;
				}
				
				// 포함 되는 경우
				if (Math.abs(stack.peek().r - rounds[i].r) > d) {
					stack.pop();
				} 
				// 외부에 있는 경우
				if(stack.isEmpty() || stack.peek().r + rounds[i].r < d) {
					stack.push(rounds[i]);
					break;
				}
			}
			
		}

		System.out.println("YES");
	}
}
