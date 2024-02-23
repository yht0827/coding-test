import java.io.*;

class Solution {
	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			String word = Long.toString(numbers[i], 2);
			word = "0" + word;
			int idx1 = -1;
			int idx2 = -1;

			for (int j = word.length() - 1; j >= 0; j--) {
				if (word.charAt(j) - '0' == 0) {
					idx1 = j;
					break;
				}
			}

			for (int j = idx1 + 1; j < word.length(); j++) {
				if (word.charAt(j) - '0' == 1) {
					idx2 = j;
					break;
				}
			}

			StringBuilder sb = new StringBuilder(word);
			sb.setCharAt(idx1, '1');
			if (idx2 != -1) {
				sb.setCharAt(idx2, '0');
			}

			answer[i] = Long.parseLong(sb.toString(), 2);

		}

		return answer;
	}
}