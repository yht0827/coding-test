import java.util.*;

class Solution {
	public String solution(String[] survey, int[] choices) {
		String answer = "";
		String[][] indicators = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};

		int[] score = {3, 2, 1, 0, 1, 2, 3};
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < survey.length; i++) {
			String s = survey[i];
			if (choices[i] < 4) {
				String temp = String.valueOf(s.charAt(0));
				map.put(temp, map.getOrDefault(temp, 0) + score[choices[i] - 1]);
			} else if (choices[i] > 4) {
				String temp = String.valueOf(s.charAt(1));
				map.put(temp, map.getOrDefault(temp, 0) + score[choices[i] - 1]);
			}
		}

		for (int i = 0; i < 4; i++) {
			if (map.getOrDefault(indicators[i][0], 0) >= map.getOrDefault(indicators[i][1], 0)) {
				answer += indicators[i][0];
			} else
				answer += indicators[i][1];
		}

		return answer;
	}
}