import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int x, int y, int n) {
		int result = -1;
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[1000001];

		queue.add(new int[] {x, 0});

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();

			if (poll[0] == y) {
				result = poll[1];
				break;
			}

			if (poll[0] + n <= y && !visited[poll[0] + n]) {
				queue.add(new int[] {poll[0] + n, poll[1] + 1});
				visited[poll[0] + n] = true;
			}

			if (poll[0] * 2 <= y && !visited[poll[0] * 2]) {
				queue.add(new int[] {poll[0] * 2, poll[1] + 1});
				visited[poll[0] * 2] = true;
			}

			if (poll[0] * 3 <= y && !visited[poll[0] * 3]) {
				queue.add(new int[] {poll[0] * 3, poll[1] + 1});
				visited[poll[0] * 3] = true;
			}
		}
		return result;
	}
}