package solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1593_문자해독 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int g = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] wCnt = new int[58];
		String W = br.readLine();
		String S = br.readLine();
		for (int i=0; i<g; i++) {
			wCnt[W.charAt(i)-'A']--;
			if (i==g-1) break;
			wCnt[S.charAt(i)-'A']++;
		}
		boolean flag = true;
		int ans = 0;

		for (int i=g-1; i<s; i++) {
			wCnt[S.charAt(i)-'A']++;
			flag = true;
			for (int j=0; j<58; j++) {
				if (wCnt[j] != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				ans++;
			}
			wCnt[S.charAt(i-g+1)-'A']--;
		}
		System.out.println(ans);
	}
}
