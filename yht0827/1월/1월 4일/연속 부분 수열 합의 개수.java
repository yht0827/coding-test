import java.util.*;

class Solution {
	public int solution(int[] elements) {
		Set<Integer> set = new HashSet<>();

		int k = 0;
		while (k <= elements.length) {
			for (int i = 0; i < elements.length; i++) {
				int sum = 0;

				for (int j = i; j < i + k; j++) {
					sum += elements[j % elements.length];
				}
				set.add(sum);
			}
			k++;
		}
		return set.size() - 1;
	}
}