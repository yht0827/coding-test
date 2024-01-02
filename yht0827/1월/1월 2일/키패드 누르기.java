class Solution {
	public String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		int left = 10, right = 12;

		for (int number : numbers) {
			if (number == 0)
				number = 11;

			if (number % 3 == 1) {
				sb.append("L");
				left = number;
			} else if (number % 3 == 0) {
				right = number;
				sb.append("R");
			} else {

				int rDis = changeDis(right, number);
				int lDis = changeDis(left, number);

				if (rDis < lDis) {
					sb.append("R");
					right = number;
				} else if (rDis > lDis) {
					sb.append("L");
					left = number;
				} else {
					sb.append(hand.equals("right") ? "R" : "L");
					if (hand.equals("right"))
						right = number;
					else
						left = number;
				}
			}
		}
		return sb.toString();
	}

	public int changeDis(int dis, int num) {
		int num1 = Math.abs(dis - num);
		return (num1 % 3) + (num1 / 3);
	}
}