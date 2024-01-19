import java.util.*;

class Solution {

	int[] answer;
	int[] dx = {0, 1, 0}, dy = {1, 0, -1};
	boolean[][] visited;

	public int[] solution(String[][] places) {
		answer = new int[5];
		visited = new boolean[5][5];

		Arrays.fill(answer, 1);

		for (int i = 0; i < 5; i++) {
			outloop:
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (places[i][j].charAt(k) == 'P') {
						visited[j][k] = true;
						dfs(i, j, k, 0, places[i]);
						visited[j][k] = false;
					}
					if (answer[i] == 0)
						break outloop;
				}
			}
		}

		return answer;
	}

	public void dfs(int no, int x, int y, int count, String[] place) {
		if (count > 2)
			return;
		if (count > 0 && place[x].charAt(y) == 'P') {
			answer[no] = 0;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny] || place[nx].charAt(ny) == 'X')
				continue;
			visited[nx][ny] = true;
			dfs(no, nx, ny, count + 1, place);
			visited[nx][ny] = false;

		}

	}

}