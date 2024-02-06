class Solution {
	public int solution(int n) {
		int answer = 0;
		String now = binary(n);
		int nowCount = 0;

		for (int i = 0; i < now.length(); i++) {
			if (now.charAt(i) == '1') {
				nowCount++;
			}
		}
		System.out.println(nowCount);

		while (true) {
			n++;
			int nextCount = 0;

			String next = binary(n);

			for (int i = 0; i < next.length(); i++) {
				if (next.charAt(i) == '1') {
					nextCount++;
				}
			}

			if (nowCount == nextCount) {
				break;
			}
		}

		return n;
	}

	public String binary(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % 2);
			n /= 2;
		}
		sb.reverse();

		return sb.toString();
	}
}