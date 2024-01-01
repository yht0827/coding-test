import java.util.*;

class Solution {
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int days = 0;

	public int[] solution(String[] maps) {
		char[][] cmap = new char[maps.length][maps[0].length()];
		boolean[][] visited = new boolean[maps.length][maps[0].length()];

		for (int i = 0; i < maps.length; i++) {
			cmap[i] = maps[i].toCharArray();
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (cmap[i][j] == 'X' || visited[i][j]) {
					continue;
				}
				list.add(DFS(i, j, maps, cmap, visited));
				days = 0;
			}
		}

		if (list.size() == 0) {
			return new int[] {-1};
		}

		Collections.sort(list);

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	static int DFS(int x, int y, String[] maps, char[][] cmap, boolean[][] visited) {
		days += Integer.parseInt(String.valueOf(cmap[x][y]));
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length() || visited[nx][ny]
				|| cmap[nx][ny] == 'X') {
				continue;
			}
			DFS(nx, ny, maps, cmap, visited);
		}

		return days;
	}
}