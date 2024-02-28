import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	public int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		for (int priority : priorities)
			pq.offer(priority);

		while (!pq.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == pq.peek()) {
					if (i == location) {
						return ++answer;
					}
					pq.poll();
					answer++;
				}
			}
		}

		return answer;
	}
}