import java.util.Arrays;

class Solution {
	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		Arrays.sort(arrayA);
		Arrays.sort(arrayB);

		int gcdA = arrayA[0];
		int gcdB = arrayB[0];

		for (int i = 1; i < arrayA.length; i++) {
			gcdA = gcd(arrayA[i], gcdA);
			gcdB = gcd(arrayB[i], gcdB);
		}

		if (!isDivided(gcdA, arrayB)) {
			answer = Math.max(answer, gcdA);
		}

		if (!isDivided(gcdB, arrayA)) {
			answer = Math.max(answer, gcdB);
		}

		return answer;
	}

	public boolean isDivided(int gcd, int[] array) {
		for (int arr : array) {
			if (arr % gcd == 0)
				return true;
		}

		return false;
	}

	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}