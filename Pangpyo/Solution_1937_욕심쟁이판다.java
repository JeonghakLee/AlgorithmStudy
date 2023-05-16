package solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1937_욕심쟁이판다 {
	
	static int N;
	static int[][] map;
	static int[][] visit;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int dfs(int x, int y) {
		if (visit[x][y] > 0) return visit[x][y]; 
		int nx, ny;
		visit[x][y] = 1;
		for (int i=0; i<4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx >= N || nx < 0 || ny >= N || ny < 0) continue;
			if (map[nx][ny] <= map[x][y]) continue; 
			visit[x][y] = Math.max(visit[x][y], dfs(nx, ny)+1);
		}
		return visit[x][y];
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++)  ans = Math.max(ans, dfs(i, j));
		}
		System.out.println(ans);
	}
}
