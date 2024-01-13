class Solution {
	public static int solution(String s) {
		int len = s.length();
		int answer = len;

		for (int i = 1; i <= len / 2; i++) {
			String target = s.substring(0, i);
			String cur;
			int cnt = 1;
			StringBuilder sb = new StringBuilder();

			for (int start = i; start <= len; start += i) {

				// 다음 자를 문자열의 길이이 더 작은 경우
				if (start + i >= s.length()) {
					cur = s.substring(start, len);
				} else {
					cur = s.substring(start, start + i);
				}

				if (cur.equals(target)) {
					cnt++;
				} else if (cnt == 1) {
					sb.append(target);
					target = cur;
				} else {
					sb.append(cnt).append(target);
					target = cur;
					cnt = 1;
				}
			}

			// 자르고 남은 문자열 ex) i=3인데 target이 2인경우
			if (i != target.length())
				sb.append(target);

			answer = Math.min(sb.length(), answer);
		}
		return answer;
	}
}