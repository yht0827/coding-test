import java.util.*;

class Solution {
	public int answer = 0;
	public boolean[] isPrime;

	public int solution(int[] nums) {
		isPrime = new boolean[3001];

		eratostenes();

		dfs(0, 0, 0, nums);

		return answer;
	}

	public void eratostenes() {
		for (int i = 2; i <= 3000; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= 3000; i++) {
			for (int j = i * i; j <= 3000; j += i) {
				isPrime[j] = false;
			}
		}
	}

	public void dfs(int depth, int start, int sum, int[] nums) {
		if (depth == 3) {
			if (isPrime[sum])
				answer++;
			return;
		}

		for (int i = start; i < nums.length; i++) {
			dfs(depth + 1, i + 1, sum + nums[i], nums);
		}
	}
}