package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution_1655_가운데를말해요 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> poped = new Stack<>();

		PriorityQueue<Integer> lowerPq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 최대 힙
		PriorityQueue<Integer> upperPq = new PriorityQueue<>();

		StringBuilder result = new StringBuilder();

		lowerPq.add(Integer.parseInt(br.readLine()));
		result.append(lowerPq.peek() + "\n");

		for (int i = 1; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			// 새로운 값 삽입 시 양 쪽 균형 맞춰 주기
			if (input > lowerPq.peek()) {
				upperPq.add(input);
				if (upperPq.size() > lowerPq.size()) {
					lowerPq.add(upperPq.poll());
				}
			} else {
				lowerPq.add(input);
				if (lowerPq.size() - upperPq.size() > 1) {
					if (!lowerPq.isEmpty()) {
						upperPq.add(lowerPq.poll());
					}
				}
			}

			result.append(lowerPq.peek() + "\n");
		}

		System.out.println(result);
	}
}