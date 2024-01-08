import java.util.*;

class Solution {
	public long solution(int[] weights) {
		long answer = 0;
		Map<Integer, Integer> cnt = new HashMap<>();
		for (int weight : weights) {
			cnt.merge(weight, 1, (v1, v2) -> {
				return v1 + 1;
			});
		}
		for (int key : cnt.keySet()) {
			long nowCnt = cnt.getOrDefault(key, 0);
			if (nowCnt == 0) {
				continue;
			}
			answer += nowCnt * (nowCnt - 1) / 2;
			int tempCnt = 0;
			if (4 * key % 3 == 0) {
				tempCnt = cnt.getOrDefault((int)((4 * key) / 3), 0);
				answer += nowCnt * tempCnt;
			}
			if (3 * key % 2 == 0) {
				tempCnt = cnt.getOrDefault((int)((3 * key) / 2), 0);
				answer += nowCnt * tempCnt;
			}
			tempCnt = cnt.getOrDefault((2 * key), 0);
			answer += nowCnt * tempCnt;
		}
		return answer;
	}
}