package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_줄세우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] LIS = new int[N + 1];
		LIS[0] = 1;

		int len = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			// 현재 최대길이에 있는 값보다 큰 경우
			if (nums[i] > LIS[len]) {
				len += 1;
				LIS[len] = nums[i];
			} else {
				idx = binarySearch(LIS, 0, len, nums[i]);
				LIS[idx] = nums[i];
			}
		}
		
		System.out.println(N - len);
	}

	private static int binarySearch(int[] LIS, int left, int right, int key) {
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (LIS[mid] < key) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}
}
