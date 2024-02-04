class Solution {
	int answer;

	public int solution(int n, long l, long r) {
		answer = 0;
		long areaLength = 1;
		int countOne = 1;
		while (n > 1) {
			areaLength *= 5L;
			countOne *= 4;
			n--;
		}
		dfs(areaLength, countOne, l, r);

		return answer;
	}

	private void dfs(long areaLength, int countOne, long start, long end) {
		if (areaLength == 1L) {
			long c = end - start + 1;
			if (c >= 3 || end == 3 || start == 3) {
				c--;
			}
			answer += c;
			return;
		}

		long startArea = start / areaLength;
		if (start % areaLength > 0) {
			startArea++;
		}
		long endArea = end / areaLength;
		if (end % areaLength > 0) {
			endArea++;
		}

		if (endArea > startArea) {// 같은 구역이 아니면
			long includArea = endArea - startArea - 1L;
			if (startArea % 5 < 3 && ((endArea) % 5 > 3 || endArea % 5 == 0)) { // 3구역 포함
				includArea--;
			}
			answer += (includArea * countOne);
			if (startArea != 3) {
				dfs(areaLength / 5, countOne / 4, start, startArea * areaLength);
			}
			if (endArea != 3) {
				dfs(areaLength / 5, countOne / 4, (endArea - 1) * areaLength + 1, end);
			}
		} else {
			if (startArea == 3)
				return;
			dfs(areaLength / 5, countOne / 4, start, end);
		}

	}

}