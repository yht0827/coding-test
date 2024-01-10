class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
		int lottoCnt = 0;
		int zeroCnt = 0;

		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				zeroCnt++;
			}
			for (int j = 0; j < 6; j++) {
				if (lottos[i] == win_nums[j]) {
					lottoCnt++;
					break;
				}
			}
		}

		int maxNum = zeroCnt + lottoCnt > 0 ? 7 - zeroCnt - lottoCnt : 6;
		int minNum = lottoCnt > 0 ? 7 - lottoCnt : 6;

		return new int[] {maxNum, minNum};
	}
}