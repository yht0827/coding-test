import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
		int[] num1 = {1, 2, 3, 4, 5};
		int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		List<Integer> list = new ArrayList<>();
		int[] check = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == num1[i % 5])
				check[0]++;
			if (answers[i] == num2[i % 8])
				check[1]++;
			if (answers[i] == num3[i % 10])
				check[2]++;
		}

		int max = Math.max(check[0], Math.max(check[1], check[2]));

		for (int i = 0; i < 3; i++)
			if (max == check[i])
				list.add(i + 1);

		return list.stream().mapToInt(i -> i.intValue()).toArray();
	}
}