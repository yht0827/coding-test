import java.util.*;

class Solution {
	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		Map<String, Set<String>> map = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();

		for (String s : id_list) {
			count.put(s, 0);
			map.put(s, new HashSet<>());
		}

		for (String s : report) {
			String[] str = s.split(" ");
			if (map.get(str[0]).add(str[1])) {
				count.put(str[1], count.get(str[1]) + 1);
			}
		}

		for (int i = 0; i < id_list.length; i++) {
			for (String s1 : map.get(id_list[i])) {
				if (count.get(s1) >= k) {
					answer[i]++;
				}
			}
		}

		return answer;
	}
}