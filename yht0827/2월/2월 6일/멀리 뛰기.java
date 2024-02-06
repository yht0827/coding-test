class Solution {
	public static long solution(int n) {
		long[] answer = new long[2001];
		answer[1] = 1;
		answer[2] = 2;

		for (int i = 3; i < 2001; i++) {
			answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
		}

		return answer[n];
	}
}