package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_3967_매직스타 {

	static final int ROW_SIZE = 5;
	static final int COL_SIZE = 9;
	static final int MAX_NUM = 12;
	static char[][] star;
	static boolean[] visit;
	static List<int[]> empty;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		star = new char[ROW_SIZE][COL_SIZE];
		visit = new boolean[MAX_NUM];
		empty = new ArrayList<>();

		for (int i = 0; i < ROW_SIZE; i++) {
			star[i] = br.readLine().toCharArray();
			for (int j = 0; j < COL_SIZE; j++) {
				if (star[i][j] == '.')
					continue;
				if (star[i][j] == 'x') {
					empty.add(new int[] { i, j });
					continue;
				}
				visit[star[i][j] - 'A'] = true;
			}
		}

		dfs(0);

	}

	private static void dfs(int depth) {
		if (depth == empty.size()) {
			if (check()) {
				for (int i = 0; i < ROW_SIZE; i++) {
					System.out.println(new String(star[i]));
				}
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < MAX_NUM; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			star[empty.get(depth)[0]][empty.get(depth)[1]] = (char) ('A' + i);
			dfs(depth + 1);
			visit[i] = false;
		}
	}

	private static boolean check() {
		int[] nums = new int[MAX_NUM];
		int idx = 0;

		for (int i = 0; i < ROW_SIZE; i++) {
			for (int j = 0; j < COL_SIZE; j++) {
				if (star[i][j] != '.')
					nums[idx++] = star[i][j] - 'A' + 1;
			}
		}

		if (nums[0] + nums[2] + nums[5] + nums[7] != 26)
			return false;
		if (nums[1] + nums[2] + nums[3] + nums[4] != 26)
			return false;
		if (nums[7] + nums[8] + nums[9] + nums[10] != 26)
			return false;
		if (nums[1] + nums[5] + nums[8] + nums[11] != 26)
			return false;
		if (nums[4] + nums[6] + nums[9] + nums[11] != 26)
			return false;
		if (nums[0] + nums[3] + nums[6] + nums[10] != 26)
			return false;

		return true;
	}

}
