import java.util.*;

class Solution {
	public static long solution(int n, int k) {
		long answer = 0;
		StringBuilder num = new StringBuilder();
		List<Long> list = new ArrayList<>();

		while (n > 0) {
			num.insert(0, (n % k));
			n /= k;
		}

		String[] split = num.toString().split("0");

		for (String s : split) {
			if (!(s.length() == 0)) {
				System.out.println(s);
				list.add(Long.parseLong(s));
			}
		}

		for (Long l : list) {
			if (checkPrime(l)) {
				answer++;
			}
		}

		return answer;
	}

	public static boolean checkPrime(long num) {
		if (num == 1) {
			return false;
		} else if (num == 2) {
			return true;
		}

		int limit = (int)Math.sqrt(num);
		for (int i = 2; i <= limit; ++i) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}