package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1593_문자해독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int WLen = Integer.parseInt(st.nextToken()); // 단어 W의 길이
		int SLen = Integer.parseInt(st.nextToken()); // 문자열 S의 길이

		char[] W = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();

		// W에 속한 문자 개수 저장
		int checkLen = 'z' - 'A' + 1;
		int[] check = new int[checkLen];
		for (int i = 0; i < WLen; i++) {
			check[W[i] - 'A']++;
		}

		int matchCnt = 0, answer = 0;
		// 슬라이딩 윈도우
		for (int i = 0; i < SLen; i++) {
			// 현재 i 번째 문자가 W에 속하는지 비교
			if (check[S[i] - 'A'] > 0) {
				matchCnt++;
			}
			check[S[i] - 'A']--;

			// 맨 앞 돌려 놓기
			if (i - WLen >= 0) {
				// 돌려 놨을 때 W에 포함된 문자라면 match count 감소
				check[S[i - WLen] - 'A']++;
				if (check[S[i - WLen] - 'A'] > 0)
					matchCnt--;
			}

			if (matchCnt == WLen) {
				answer++;
			}
		}

		System.out.println(answer);
	}

}