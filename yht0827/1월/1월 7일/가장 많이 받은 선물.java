import java.util.*;

public class Solution {
	public int solution(String[] friends, String[] gifts) {
		int answer = 0;

		Map<String, Integer> dict = new HashMap<>();
		for (int i = 0; i < friends.length; i++)
			dict.put(friends[i], i);

		int[] intArray = new int[friends.length];
		int[][] giftArrays = new int[friends.length][friends.length];

		for (int i = 0; i < gifts.length; i++) {
			String[] strs = gifts[i].split(" ");
			giftArrays[dict.get(strs[0])][dict.get(strs[1])]++;
			intArray[dict.get(strs[0])]--;
			intArray[dict.get(strs[1])]++;
		}

		for (int i = 0; i < intArray.length; i++) {
			int num = 0;
			for (int j = 0; j < intArray.length; j++) {
				if (i == j)
					continue;

				if (giftArrays[j][i] < giftArrays[i][j]
					|| (giftArrays[j][i] == giftArrays[i][j] && intArray[i] < intArray[j]))
					num++;
			}
			if (num > answer) {
				answer = num;
			}
		}

		return answer;
	}
}