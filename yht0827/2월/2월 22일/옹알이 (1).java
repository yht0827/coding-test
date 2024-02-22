class Solution {
	public int solution(String[] babbling) {
		int answer = 0;
		String[] check = {"aya", "ye", "woo", "ma"};

		for (String b : babbling) {
			for (String c : check) {
				b = b.replace(c, " ");
			}
			if (b.replaceAll(" ", "").equals("")) {
				answer++;
			}
		}
		return answer;
	}
}
