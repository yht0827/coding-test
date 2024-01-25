class Solution {
	int[][] map;

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length]; // 정답 개수 배열
		this.map = new int[rows][columns]; // 맵 생성

		// map 초기화
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = i * columns + j + 1;
			}
		}

		// 회전 후 최소값 저장
		for (int i = 0; i < queries.length; i++) {
			answer[i] = move(queries[i]);
		}

		return answer;
	}

	// 회전 순서 위 왼쪽 아래 오른쪽 역순으로 진행
	public int move(int[] info) {

		int x1 = info[0] - 1; // 시작 범위 x
		int y1 = info[1] - 1; // 시작 범위 y
		int x2 = info[2] - 1; // 끝 범위 x
		int y2 = info[3] - 1; // 끝 범위 y

		int start = this.map[x1][y1]; //시작 위치 값 임시 저장
		int min = start; // 최소 값 저장 처음에는 시작 위치 값으로 저장

		// 아래에서 위
		for (int i = x1; i < x2; i++) {
			this.map[i][y1] = this.map[i + 1][y1];
			// 최소 값 비교
			if (min > this.map[i][y1]) {
				min = this.map[i][y1];
			}
		}

		// 오른쪽에서 왼쪽
		for (int i = y1; i < y2; i++) {
			this.map[x2][i] = this.map[x2][i + 1];
			if (min > this.map[x2][i]) {
				min = this.map[x2][i];
			}
		}

		// 위에서 아래
		for (int i = x2; i > x1; i--) {
			this.map[i][y2] = this.map[i - 1][y2];
			if (min > this.map[i][y2])
				min = this.map[i][y2];
		}
		// 왼쪽에서 오른쪽
		for (int i = y2; i > y1; i--) {
			this.map[x1][i] = this.map[x1][i - 1];
			if (min > this.map[x1][i])
				min = this.map[x1][i];
		}

		this.map[x1][y1 + 1] = start; // 처음 위치 저장

		return min; // 최소값 반환
	}
}