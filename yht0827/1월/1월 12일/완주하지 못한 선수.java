import java.util.Arrays;

class Solution {
	public String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		int len = participant.length - 1;
		String answer =  participant[len];

		for (int i = 0; i < len; i++) {
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
		}

		return answer;
	}
}