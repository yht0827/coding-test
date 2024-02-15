class Solution {
	public String solution(String number, int k) {
		String answer = "";
		int ansLen = number.length() - k;
		int idx = 0;
		int remem = 0;
		for (int i = answer.length(); i < ansLen; i++) {
			char max = '0';
			for (int j = idx; j < number.length() - ansLen + answer.length() + 1; j++) {
				if (max < number.charAt(j)) {
					max = number.charAt(j);
					remem = j + 1;
				}
			}
			idx = remem;
			answer += max;
		}
		return answer;
	}
}