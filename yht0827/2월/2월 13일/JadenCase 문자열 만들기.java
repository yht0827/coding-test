class Solution {
	public String solution(String s) {
		String answer = "";
		String[] sArr = s.toLowerCase().split("");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < sArr.length; i++) {
			if (i == 0)
				sArr[i] = sArr[i].toUpperCase();

			if (" ".equals(sArr[i])) {
				if (!(i == sArr.length - 1))
					sArr[i + 1] = sArr[i + 1].toUpperCase();
			}

			sb.append(sArr[i]);
		}

		answer = sb.toString();

		return answer;
	}
}