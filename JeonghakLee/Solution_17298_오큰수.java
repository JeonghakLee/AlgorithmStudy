package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_17298_오큰수 {
	static class Info {
		int idx, num;

		public Info(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] answer = new int[N];
		Stack<Info> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Arrays.fill(answer, -1);

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				stack.push(new Info(i, input));
				continue;
			}

			while (!stack.isEmpty()) {
				if (stack.peek().num < input) {
					Info top = stack.pop();
					answer[top.idx] = input;
				} else {
					break;
				}
			}
			stack.push(new Info(i, input));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int ans : answer) {
			sb.append(ans + " ");
		}
		
		System.out.println(sb.toString());
	}
}
