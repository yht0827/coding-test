class Solution {
	static int answer = 0;

	public static int solution(int k, int[][] dungeons) {
		dfs(0, dSize, k, new boolean[dungeons.length], dungeons);
		return answer;
	}

	private static void dfs(int cnt, int dSize, int k, boolean[] check, int[][] dungeons) {
		for (int j = 0; j < dSize; j++) {
			if (check[j] || k < dungeons[j][0])
				continue;

			check[j] = true;
			dfs(cnt + 1, dSize, k - dungeons[j][1], check, dungeons);
			check[j] = false;
		}
		answer = Math.max(answer, cnt);
	}
}