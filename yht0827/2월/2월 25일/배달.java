class Solution {
	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}
				arr[i][j] = 500001;
			}
		}

		for (int i = 0; i < road.length; i++) {
			if (arr[road[i][0] - 1][road[i][1] - 1] >= road[i][2]) {
				arr[road[i][0] - 1][road[i][1] - 1] = road[i][2];
				arr[road[i][1] - 1][road[i][0] - 1] = road[i][2];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (arr[0][i] <= K) {
				answer++;
			}
		}
		return answer;
	}
}