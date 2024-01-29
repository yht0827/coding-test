import java.util.Arrays;

class Solution {
	public int solution(int[] numbers) {
		return 45 - Arrays.stream(numbers).sum();
	}
}