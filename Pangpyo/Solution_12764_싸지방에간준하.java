package solve;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_12764_싸지방에간준하 {

	static class Seat implements Comparable<Seat> {
		int n, t;

		public Seat(int n, int t) {
			this.n = n;
			this.t = t;
		}

		@Override
		public int compareTo(Seat o) {
			return this.t - o.t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int n = 0;

		int[][] peaple = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			peaple[i][0] = Integer.parseInt(st.nextToken());
			peaple[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(peaple, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		int[] com = new int[N];
		PriorityQueue<Seat> useSeats = new PriorityQueue<>();
		PriorityQueue<Seat> emptySeats = new PriorityQueue<>(new Comparator<Seat>() {
			@Override
			public int compare(Seat o1, Seat o2) {
				return o1.n - o2.n;
			}
		});
		useSeats.offer(new Seat(0, -1));
		for (int[] person:peaple) {
			while (!useSeats.isEmpty() && useSeats.peek().t <= person[0]) {
				emptySeats.offer(useSeats.poll());
			}
			if (!emptySeats.isEmpty() && emptySeats.peek().t < person[0]) {
				Seat seat = emptySeats.poll();
				seat.t = person[1];
				com[seat.n]++;
				useSeats.offer(seat);
			}else {
				useSeats.offer(new Seat(++n, person[1]));
				com[n]++;
			}
		}
		System.out.println(n+1);
		for (int i=0; i<=n; i++) {
			System.out.print(com[i]+" ");
		}

	}
}
