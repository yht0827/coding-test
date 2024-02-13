class Solution {
	public boolean solution(int x) {
		int sum = 0;
		boolean answer = true;

		for (String s : Integer.toString(x).split("")) {
			sum += Integer.parseInt(s);
		}

		if (x % sum != 0)
			answer = false;

		return answer;
	}
}