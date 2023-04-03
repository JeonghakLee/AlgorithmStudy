package algostudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7570_줄세우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[Integer.parseInt(st.nextToken())-1] = i;
			
		}
		int temp = 1;
		int ans = 1;
		for (int i=1; i<N; i++) {
			if (nums[i] > nums[i-1]) temp++;
			else temp = 1;
			ans = Math.max(ans, temp);
		}
		
		System.out.println(N-ans);
		
	}
}
