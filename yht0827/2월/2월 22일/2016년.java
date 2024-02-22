class Solution {
	public String solution(int a, int b) {
		String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};

		int result = 4 + b;
		for (int i = 1; i < a; i++) {
			result += months[i];
		}

		return days[result % 7];
	}
}