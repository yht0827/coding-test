class Solution {

	static int answer = 0;
	static int cnt = 0;
	static boolean flag;
	static char[] alpha = {'A', 'E', 'I', 'O', 'U'};

	public int solution(String word) {

		StringBuilder sb = new StringBuilder();
		backTrack(word, sb, 0);

		return answer;
	}

	public void backTrack(String word, StringBuilder sb, int index) {

		if (flag)
			return;

		String s = sb.toString();

		if (word.equals(s)) {
			answer = cnt;
			flag = true;
			return;
		}

		if (index < 5) {
			for (int i = 0; i < 5; i++) {
				sb.append(alpha[i]);
				cnt++;
				backTrack(word, sb, index + 1);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}