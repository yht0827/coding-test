class Solution {
	public int[] solution(int n) {
		int[] answer = {};

		int[] snail = new int[(1 + n) * n / 2];

		int idx = 0;
		int dis = 1;
		int num = 1;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				snail[0] = num++;
				for (int j = 0; j < n - 1; j++) {
					idx = idx + dis++;
					snail[idx] = num++;
				}
			} else if (i % 3 == 1) {
				for (int j = 0; j < n - i; j++) {
					idx++;
					snail[idx] = num++;
				}
			} else if (i % 3 == 2) {
				for (int j = 0; j < n - i; j++) {
					idx = idx - dis--;
					snail[idx] = num++;
				}
			} else {
				for (int j = 0; j < n - i; j++) {
					idx = idx + dis++;
					snail[idx] = num++;
				}
			}
		}

		answer = snail;

		return answer;
	}
}