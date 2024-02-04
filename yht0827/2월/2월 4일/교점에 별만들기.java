import java.util.*;

class Solution {
	public List<String> solution(int[][] line) {
		List<String> answer = new ArrayList<>();
		int len = line.length;
		int Xmax = Integer.MIN_VALUE, Xmin = Integer.MAX_VALUE, Ymax = Integer.MIN_VALUE, Ymin = Integer.MAX_VALUE;
		List<List<Integer>> cor = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {

				long a = line[i][0];
				long b = line[i][1];
				long e = line[i][2];

				long c = line[j][0];
				long d = line[j][1];
				long f = line[j][2];
				long denominator = (a * d) - (b * c);
				if (denominator == 0)
					continue;

				long numerator1 = (b * f) - (e * d);
				long numerator2 = (e * c) - (a * f);
				if (numerator1 % denominator != 0 || numerator2 % denominator != 0)
					continue;

				int x = (int)(numerator1 / denominator);
				int y = (int)(numerator2 / denominator);

				List<Integer> temp = Arrays.asList(x, y);

				if (!cor.contains(temp))
					cor.add(temp);

				Xmax = Math.max(Xmax, x);
				Xmin = Math.min(Xmin, x);
				Ymax = Math.max(Ymax, y);
				Ymin = Math.min(Ymin, y);
			}
		}

		for (int i = Ymin; i <= Ymax; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = Xmin; j <= Xmax; j++) {
				sb.append(".");
			}
			answer.add(sb.toString());
		}

		for (List<Integer> list : cor) {
			StringBuilder sb = new StringBuilder(answer.get(Math.abs(list.get(1) - Ymax)));
			sb.setCharAt(Math.abs(list.get(0) - Xmin), '*');
			answer.set(Math.abs(list.get(1) - Ymax), sb.toString());
		}

		return answer;
	}
}