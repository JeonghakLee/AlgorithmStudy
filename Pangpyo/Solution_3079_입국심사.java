package solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3079_입국심사 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] times = new long[N];
		long s = 0;
		long e = 0;
		for (int i=0; i<N; i++) {
			times[i] = Long.parseLong(br.readLine());
			e = Math.max(e, times[i]);
		}
		e *= M;
		long mid;
		long temp;
		long ans=0;
		while (s<=e) {
			mid = (s+e)/2;
			temp = 0;
			for (long time: times) {
				temp += mid/time;
				if (temp > M) break;
			}
			if (temp >= M) {
				e = mid-1;
				ans = mid;
			}else {
				s = mid+1;
			}
			
		}
		System.out.println(ans);
	}
}
