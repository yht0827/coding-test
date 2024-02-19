class Solution {
	public String solution(String s) {
		String answer = "";

		String[] numbers = s.split(" ");
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < numbers.length; i++) {
			int number = Integer.parseInt(numbers[i]);

			min = Math.min(min, number);
			max = Math.max(max, number);
		}

		answer = min + " " + max;
		return answer;
	}
}