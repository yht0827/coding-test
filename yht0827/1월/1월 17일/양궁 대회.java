import java.util.*;

class Solution {

	static int[] answer = new int[11];
	static int maxScore = Integer.MIN_VALUE;
	static int[] ryan;
	static int[] aPeach;
	static int N;

	public static int[] solution(int n, int[] info) {
		ryan = new int[11];
		aPeach = info.clone();
		N = n;
		dfs(0, 0);

		if (Arrays.stream(answer).sum() == 0) {
			return new int[] {-1};
		}

		return answer;
	}

	public static void dfs(int idx, int cnt) {
		if (cnt == N) {
			int ryanScore = 0, aPeachScore = 0;

			for (int i = 0; i < 11; i++) {
				if (aPeach[i] == 0 && ryan[i] == 0)
					continue;
				if (aPeach[i] < ryan[i])
					ryanScore += 10 - i;
				else
					aPeachScore += 10 - i;
			}

			if (ryanScore > aPeachScore) {
				int diff = ryanScore - aPeachScore;

				if (diff > maxScore) {
					maxScore = diff;
					answer = ryan.clone();
				} else if (diff == maxScore) {
					for (int i = 10; i >= 0; i--) {
						if (ryan[i] != answer[i]) {
							if (ryan[i] > answer[i]) {
								answer = ryan.clone();
							}
							return;
						}
					}
				}
			}

		} else {
			for (int i = idx; i < 11; i++) {
				ryan[i]++;
				dfs(i, cnt + 1);
				ryan[i]--;
			}
		}

	}
}