import java.util.LinkedList;
import java.util.Queue;

class Solution {

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public int solution(String[] maps) {
		int n = maps.length;
		int m = maps[0].length();
		boolean[][][] visited = new boolean[n][m][2];
		Queue<Node> q = new LinkedList<>();
		int[] start = find(maps, 'S');
		q.add(new Node(start[0], start[1], 0, 0));
		visited[start[0]][start[1]][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (maps[cur.x].charAt(cur.y) == 'E' && cur.lever == 1) {
				return cur.time;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nlever = cur.lever;

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx].charAt(ny) == 'X') {
					continue;
				}

				if (maps[nx].charAt(ny) == 'L') {
					nlever = 1;
				}

				if (!visited[nx][ny][nlever]) {
					visited[nx][ny][nlever] = true;
					q.add(new Node(nx, ny, cur.time + 1, nlever));
				}
			}
		}

		return -1;
	}

	private int[] find(String[] maps, char c) {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) == c) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}

	static class Node {
		int x, y, time, lever;

		public Node(int x, int y, int time, int lever) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.lever = lever;
		}
	}
}