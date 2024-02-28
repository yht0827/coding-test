import java.util.*;

class Solution {
	public int solution(int n) {
		int answer = 0;
		String ans = "";
		while (n != 0) {
			ans += n % 3;
			n /= 3;
		}
		return Integer.parseInt(ans, 3);
	}
}