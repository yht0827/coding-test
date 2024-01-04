import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		HashMap<String, Integer> termlist = new HashMap<>();
		for (String item : terms) {
			String[] temp = item.split(" ");
			termlist.put(temp[0], Integer.parseInt(temp[1]));
		}

		ArrayList<Integer> stopList = new ArrayList<>();
		String[] todayArr = today.split("\\.");
		int todayDate = Integer.parseInt(todayArr[0]) * 12 * 28 + Integer.parseInt(todayArr[1]) * 28
			+ Integer.parseInt(todayArr[2]);

		for (int i = 0; i < privacies.length; i++) {
			String[] temp = privacies[i].split(" ");
			String[] date = temp[0].split("\\.");

			int month = Integer.parseInt(date[1]) + termlist.get(temp[1]);
			int year = Integer.parseInt(date[0]);
			int day = Integer.parseInt(date[2]);

			int updateDay = (year * 12 * 28) + (month * 28) + day;
			if (updateDay <= todayDate) {
				stopList.add(i + 1);
			}
		}

		return stopList.stream().flatMapToInt(m -> IntStream.of(m)).toArray();
	}
}