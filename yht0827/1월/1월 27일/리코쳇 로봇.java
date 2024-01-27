import java.util.*;

class Point {
	int x;
	int y;

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

class Solution {
	int N, M;
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	public int solution(String[] board) {
		N = board.length;
		M = board[0].length();
		int[][] visit = new int[N][M];
		Queue<Point> q = new ArrayDeque();

		for (int i = 0; i < N; ++i) {
			String s = board[i];
			for (int j = 0; j < M; ++j) {
				if (s.charAt(j) == 'R') {
					q.add(new Point(i, j));
					visit[i][j] = 1;
					break;
				}
			}
		}

		int answer = -1;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (board[cur.x].charAt(cur.y) == 'G') {
				answer = visit[cur.x][cur.y] - 1;
				break;
			}

			for (int d = 0; d < 4; ++d) {
				int nextX = cur.x + dx[d];
				int nextY = cur.y + dy[d];
				while (true) {
					if (isInRange(nextX, nextY) && board[nextX].charAt(nextY) != 'D') {
						nextX += dx[d];
						nextY += dy[d];
					} else {

						nextX -= dx[d];
						nextY -= dy[d];
						break;
					}
				}

				if (visit[nextX][nextY] == 0) {
					q.add(new Point(nextX, nextY));
					visit[nextX][nextY] = visit[cur.x][cur.y] + 1;
				}
			}
		}

		return answer;
	}

	public boolean isInRange(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M)
			return true;
		return false;
	}
}