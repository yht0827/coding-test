import java.util.*;

class Solution {
	public int solution(String[][] book_time) {
		int answer = 0;
		int size = book_time.length;
		PriorityQueue<Integer> end = new PriorityQueue<>();

		Arrays.sort(book_time, (a, b) -> (TimeToInt(a[0]) - TimeToInt(b[0])));

		int idx = 0;
		int time = 0;
		int count = 0;

		while (idx != size) {
			end.add(TimeToInt(book_time[idx][1]) + 10);
			time = TimeToInt(book_time[idx][0]);
			count++;
			idx++;

			while (true) {
				if (time >= end.peek()) {
					end.poll();
					count--;
				} else {
					break;
				}
			}

			answer = Math.max(answer, count);
		}

		return answer;
	}

	public int TimeToInt(String time) {
		String[] clock = time.split(":");

		return Integer.parseInt(clock[0]) * 60 + Integer.parseInt(clock[1]);

	}
}