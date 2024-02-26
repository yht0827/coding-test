import java.util.*;

public class Solution {
	public static int solution(int n) {
		int ans = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				ans += 1;
			}
			n /= 2;
		}
		return ans;
	}
}