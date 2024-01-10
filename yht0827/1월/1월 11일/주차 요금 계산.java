import java.util.*;

class Solution {
	public int[] solution(int[] fees, String[] records) {
		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> result = new TreeMap<>();

		for (String record : records) {
			String[] str = record.split(" ");
			if (str[2].equals("IN")) {
				if (!result.containsKey(str[1])) {
					result.put(str[1], 0);
				}
				map.put(str[1], calc(str[0]));
			} else {
				result.put(str[1], result.get(str[1]) + calc(str[0]) - map.get(str[1]));
				map.remove(str[1]);
			}
		}

		if (!map.isEmpty()) {
			for (String str : map.keySet()) {
				result.put(str, result.get(str) + calc("23:59") - map.get(str));
			}
		}

		List<Integer> answer = new ArrayList<>();

		for (String key : result.keySet()) {
			int temp = fees[1];
			int time = result.get(key);

			if (time >= fees[0]) {
				temp += (int)Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
			}
			answer.add(temp);
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	private int calc(String s) {
		String[] str = s.split(":");
		return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
	}
}