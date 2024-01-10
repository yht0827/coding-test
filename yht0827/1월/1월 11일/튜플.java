import java.util.Comparator;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
	public int[] solution(String s) {
		int[] answer = {};
		String[] str = s.replaceAll("[{}]", " ").trim().split(" , ");
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}

		});

		answer = new int[str.length];
		int idx = 0;
		HashSet<Integer> hashset = new HashSet<>();
		for (String temp : str) {
			String[] str1 = temp.split("[,]");
			for (String temp1 : str1) {
				int a = Integer.parseInt(temp1);
				if (!hashset.contains(a)) {
					answer[idx++] = a;
					hashset.add(a);
				}
			}
		}

		return answer;
	}
}