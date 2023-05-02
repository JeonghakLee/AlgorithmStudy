package solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_9576_책나눠주기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N, M, a, b, ans;
		boolean[] visit;
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			visit = new boolean[N+1];
			
			int[][] P = new int[M][2];
			
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				P[i][0] = Integer.parseInt(st.nextToken());
				P[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(P, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1]==o2[1]) return o1[0]-o2[0];
					return o1[1] -o2[1];
				}
			});

			
			for (int i=0; i<M; i++) {
				a = P[i][0];
				b = P[i][1];
				
				for (int j=a; j<=b; j++) {
					if (visit[j]) continue;
					visit[j] = true;
					ans++;
					break;
				}
			}
			
			System.out.println(ans);
		}
	
	}
}
