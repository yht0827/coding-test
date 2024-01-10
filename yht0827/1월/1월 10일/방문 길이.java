class Solution {
	static int[] dir = {5, 5};
	static boolean[][][][] map = new boolean[11][11][11][11];
	static int answer = 0;

	public int solution(String dirs) {
		for (String str : dirs.split(""))
			move(str);
		return answer;
	}

	public static void move(String str) {
		int x = dir[0];
		int y = dir[1];

		switch (str) {
			case "U":
				if (++dir[1] > 10) {
					dir[1]--;
					return;
				}
				break;
			case "L":
				if (--dir[0] < 0) {
					dir[0]++;
					return;
				}
				break;
			case "R":
				if (++dir[0] > 10) {
					dir[0]--;
					return;
				}
				break;
			default:
				if (--dir[1] < 0) {
					dir[1]++;
					return;
				}
				break;
		}

		if (!map[x][y][dir[0]][dir[1]] && !map[dir[0]][dir[1]][x][y]) {
			answer++;
			map[x][y][dir[0]][dir[1]] = true;
			map[dir[0]][dir[1]][x][y] = true;
		}
	}
}