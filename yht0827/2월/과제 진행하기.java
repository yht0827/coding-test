import java.util.*;

class Solution {
	public String[] solution(String[][] plans) {
		ArrayList<String> result = new ArrayList<>();
		ArrayList<homeWork> homework = new ArrayList<>();
		Stack<homeWork> stack = new Stack<>();
		HashMap<Integer, homeWork> info = new HashMap<>();
		int length = plans.length;

		for (String[] plan : plans) {
			String[] split = plan[1].split(":");
			int playTime = Integer.parseInt(plan[2]);
			int start = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
			info.put(start, new homeWork(plan[0], start, playTime));
			homework.add(new homeWork(plan[0], start, playTime));
		}

		homework.sort((s1, s2) -> s1.start != s2.start ? s1.start - s2.start : s1.playTime - s2.playTime);

		int time = homework.get(0).start;
		int cnt = 0;

		while (cnt < length) {
			if (!stack.isEmpty()) {
				stack.peek().playTime -= 1;
				if (stack.peek().playTime == 0) {
					result.add(stack.peek().name);
					stack.pop();
					cnt++;
				}
			}

			if (info.containsKey(time)) {
				stack.add(info.get(time));
			}
			time++;
		}
		String[] answer = result.toArray(new String[result.size()]);
		return answer;
	}

	static class homeWork {
		String name;
		int start;
		int playTime;

		public homeWork(String name, int start, int playTime) {
			this.name = name;
			this.start = start;
			this.playTime = playTime;
		}
	}
}