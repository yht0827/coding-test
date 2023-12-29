import java.util.*;

class Solution {

	static int N, M;
	static int[][] board, count;
	static List<int[]> point = new ArrayList<>();
	static Set<Integer> nums = new HashSet<>();
	static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public int solution(int[][] land) {
		int answer = 0;

		N = land.length;
		M = land[0].length;
		board = land;
		count = new int[N][M];

		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] != 1)
					continue;
				check(i, j, idx++);
			}
		}

		int std, val;
		for (int j = 0; j < M; j++) {
			val = 0;
			nums.clear();

			for (int i = 0; i < N; i++) {
				if (nums.contains(count[i][j]))
					continue;

				nums.add(count[i][j]);
				val += board[i][j];
			}
			answer = Math.max(answer, val);
		}

		return answer;
	}

	static void check(int x, int y, int idx) {
		Queue<int[]> q = new ArrayDeque();
		q.offer(new int[] {x, y});

		point.clear();
		point.add(new int[] {x, y});

		int cnt = 1;
		board[x][y] = 0;
		count[x][y] = idx;

		int[] now;
		int dx, dy, nx, ny;
		while (!q.isEmpty()) {
			now = q.poll();
			dx = now[0];
			dy = now[1];

			for (int[] move : moves) {
				nx = dx + move[0];
				ny = dy + move[1];

				if (!isPossible(nx, ny))
					continue;
				if (board[nx][ny] != 1)
					continue;

				board[nx][ny] = 0;
				q.offer(new int[] {nx, ny});
				point.add(new int[] {nx, ny});
				cnt++;
			}
		}

		for (int[] p : point) {
			board[p[0]][p[1]] = cnt;
			count[p[0]][p[1]] = idx;
		}
	}

	static boolean isPossible(int x, int y) {
		return (0 <= x && x < N) && (0 <= y && y < M);
	}
}