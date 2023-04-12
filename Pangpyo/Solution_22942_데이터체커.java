package algostudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_22942_데이터체커 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] C = new int[N][2];
		int x, r;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			C[i][0] = x-r;
			C[i][1] = x+r;
		}
		Arrays.sort(C, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) return o1[1]-o2[1];
				return o1[0] - o2[0];
			}
		});
		Stack<int[]> stack = new Stack<>();
		int a, b, na, nb;
		String ans = "YES";
		for(int i=0; i<N; i++) {
			while (true) {
				if (stack.isEmpty()) {
					stack.add(C[i]);
					break;
				}
				else {
					a = stack.peek()[0];
					b = stack.peek()[1];
					na = C[i][0];
					nb = C[i][1];
					if (a < na && nb < b) {
						stack.add(C[i]);
						break;
					}
					else if ((na < b && b < nb) || na == a || nb == b) {
						ans = "NO";
						break;
					}
					else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(ans);
	}
}
