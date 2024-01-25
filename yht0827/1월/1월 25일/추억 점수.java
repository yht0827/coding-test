import java.util.*;

class Solution {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];

		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[i].length; j++) {

				if (Arrays.asList(name).indexOf(photo[i][j]) != -1) {
					answer[i] += yearning[Arrays.asList(name).indexOf(photo[i][j])];
				}
			}
		}
		return answer;
	}
}