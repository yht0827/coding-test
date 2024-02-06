import java.util.Arrays;

public class Solution {
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i] * B[A.length - i - 1];
		}

		return sum;
	}
}