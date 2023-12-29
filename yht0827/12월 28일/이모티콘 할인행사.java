import java.util.*;

class Solution {
	public int[] solution(int[][] users, int[] emoticons) {
		List<int[]> list = new ArrayList<>();

		for (int i = 10; i <= 40; i += 10) {
			int[] totalPrices = new int[users.length];
			rSolution(list, users, emoticons, 0, i, totalPrices);
		}

		int max = 0;
		int maxSum = 0;
		for (int[] total : list) {
			int buyerCnt = 0;
			for (int i = 0; i < users.length; i++) {
				int limit = users[i][1];
				if (total[i] >= limit) {
					buyerCnt++;
					total[i] = 0;
				}
			}

			int sum = Arrays.stream(total).sum();
			if (max < buyerCnt) {
				max = buyerCnt;
				maxSum = sum;
			} else if (max == buyerCnt) {
				maxSum = Math.max(maxSum, sum);
			}
		}

		return new int[]{max, maxSum};
	}

	private void rSolution(List<int[]> list, int[][] users, int[] emoticons, int depth, int discount, int[] totalPrices) {
		if (depth == emoticons.length) {
			return;
		}

		int[] clone = totalPrices.clone();
		for (int i = 0; i < users.length; i++) {
			int rate = users[i][0];
			if (discount < rate) {
				continue;
			}

			clone[i] += (emoticons[depth] * (100 - discount) / 100);
		}

		for (int i = 10; i <= 40; i += 10) {
			rSolution(list, users, emoticons, depth + 1, i, clone);
		}

		if (depth == emoticons.length - 1) {
			list.add(clone);
		}
	}
}